package pl.prz.l6.systempotwierdzaniawizyt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.CustomerDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.EmployeeDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.VisitDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.model.*;
import pl.prz.l6.systempotwierdzaniawizyt.repository.*;
import pl.prz.l6.systempotwierdzaniawizyt.service.VisitService;
import pl.prz.l6.systempotwierdzaniawizyt.utilities.RandomString;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.security.SecureRandom;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final SystemSettingsRepository systemSettingsRepository;

    @Autowired
    public VisitController(VisitService visitService, CustomerRepository customerRepository, EmployeeRepository employeeRepository, UserRepository userRepository, CompanyRepository companyRepository, SystemSettingsRepository systemSettingsRepository) {
        this.visitService=visitService;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.userRepository=userRepository;
        this.companyRepository=companyRepository;
        this.systemSettingsRepository=systemSettingsRepository;
    }

    @GetMapping("/user/visits/{visitId}")
    public String getVisitDetailsPage(@PathVariable("visitId") long visitId, Model model) {
        Optional<Visit> visit = visitService.findById(visitId);

        if (visit.isPresent()) {
            VisitDTO visitDTO = Converter.toVisitDTO(visit.get());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            visitDTO.setStart(sdf.format(visit.get().getStart()));
            visitDTO.setEnd(sdf.format(visit.get().getEnd()));
            model.addAttribute("visitDTO", visitDTO);

            Employee employee = visit.get().getEmployee();
            if (employee != null) {
                EmployeeDTO employeeDTO = Converter.toEmployeeDTO(employee);

                model.addAttribute("employeeDTO", employeeDTO);
            }
            Customer customer = visit.get().getCustomer();
            if (customer != null) {
                CustomerDTO customerDTO = Converter.toCustomerDTO(customer);

                model.addAttribute("customerDTO", customerDTO);
            }
        }
        return "visit-details";
    }

    @GetMapping("/user/visits/new")
    public String getNewVisitPage(VisitDTO visitDTO, Model model){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Customer> customers = customerRepository.findAllByCompany(user.get().getCompany());
        List<Employee> employees = employeeRepository.findAllByCompany(companyRepository.findById(user.get().getCompany().getIdCompany()).get());
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        return "new-visit";

    }

    @PostMapping("/user/visits/new")
    public String createVisit(@Valid @ModelAttribute VisitDTO visitDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new-visit";
        }else{
            Visit visit = Converter.fromVisitDTO(visitDTO);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            try{
                visit.setStart(sdf.parse(visitDTO.getStart()));
                visit.setEnd(sdf.parse(visitDTO.getEnd()));
            }catch(ParseException e){
                //
            }
            Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            Optional<SystemSettings> systemSettings = systemSettingsRepository.findById((long)1);
            Optional<Customer> customer = customerRepository.findById(Long.valueOf(visitDTO.getIdCustomer()));

            visit.setCustomer(customer.get());
            visit.setCompany(companyRepository.findById(user.get().getCompany().getIdCompany()).get());
            visit.setEmployee(employeeRepository.findById(visitDTO.getIdEmployee()).get());

            RandomString randomString = new RandomString(20);
            String token;
            token = randomString.nextString();
            visit.setToken(token);

            visitService.save(visit);

            // Recipient's email ID needs to be mentioned.
            String to = customer.get().getEmail();

            // Sender's email ID needs to be mentioned
            String from = systemSettings.get().getEmailAddress();

            // Assuming you are sending email from localhost
            String host = systemSettings.get().getEmailServer();

            String username = systemSettings.get().getEmailLogin();
            String password = systemSettings.get().getEmailPassword();

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.user", username);
            properties.setProperty("mail.password", password);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", "587");

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // Set Subject: header field
                message.setSubject("Potwierdzenie wizyty");

                // Now set the actual message
                // Na razie jest szablon w kodzie, powinien być pobierany z bazy danych!
                String content = "<h1>Witaj, ";
                content += customer.get().getFirstName();
                content += " ";
                content += customer.get().getLastName();
                content += "!</h1><p>Potwierdź swoją wizytę klikając w <a href=\"http://localhost:8080/confirm?token=";
                content += new String(token);
                content += "&value=yes\">ten odnośnik</a></p><p>Odwołaj swoją wizytę klikając w <a href=\"http://localhost:8080/confirm?token=";
                content += new String(token);
                content += "&value=no\">ten odnośnik</a></p>";
                message.setContent(content, "text/html; charset=utf-8");

                // Send message
                Transport.send(message);
            } catch (MessagingException mex) {
                // mex.printStackTrace();
            }
        }
        return "redirect:/user";
    }

    @GetMapping("/user/visits/{id}/edit")
    public String getEditVisitPage(@PathVariable long id, VisitDTO visitDTO, Model model){
        Optional<Visit> visit = visitService.findById(id);
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Customer> customers = customerRepository.findAllByCompany(user.get().getCompany());
        List<Employee> employees = employeeRepository.findAllByCompany(companyRepository.findById(user.get().getCompany().getIdCompany()).get());

        if (visit.isPresent()) {
            visitDTO = Converter.toVisitDTO(visit.get());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            visitDTO.setStart(sdf.format(visit.get().getStart()));
            visitDTO.setEnd(sdf.format(visit.get().getEnd()));
            model.addAttribute("visitDTO", visitDTO);

            model.addAttribute("employees", employees);
            model.addAttribute("customers", customers);

        }
        return "edit-visit";
    }

    @PostMapping("/user/visits/{id}/edit")
    public String editVisitById(@PathVariable long id, VisitDTO visitDTO){
        Optional<Visit> visit = visitService.findById(id);
        Visit editVisit = visit.get();
        editVisit = Converter.fromVisitDTO(visitDTO);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try{
            editVisit.setStart(sdf.parse(visitDTO.getStart()));
            editVisit.setEnd(sdf.parse(visitDTO.getEnd()));
        }catch (ParseException e){
            //
        }
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        editVisit.setCustomer(customerRepository.findById(Long.valueOf(visitDTO.getIdCustomer())).get());
        editVisit.setCompany(companyRepository.findById(user.get().getCompany().getIdCompany()).get());
        editVisit.setEmployee(employeeRepository.findById(visitDTO.getIdEmployee()).get());
        editVisit.setVerification(visitDTO.isVerification());
        editVisit.setCompleted(visitDTO.isCompleted());
        editVisit.setCanceled(visitDTO.isCanceled());

        visitService.save(editVisit);
        return "redirect:/user";
    }

    @GetMapping("/user/visits/{id}/delete")
    public String deleteVisit(@PathVariable("id") long id){
        if(visitService.existsById(id)){
            visitService.deleteById(id);
        }
        return "redirect:/user";
    }




}
