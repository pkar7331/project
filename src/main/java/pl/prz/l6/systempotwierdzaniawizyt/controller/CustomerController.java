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
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.Customer;
import pl.prz.l6.systempotwierdzaniawizyt.model.User;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CompanyRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CustomerRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CompanyRepository companyRepository, UserRepository userRepository){
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user/customers/new")
    public String getNewCustomerPage(CustomerDTO customerDTO){return "new-customer";}

    @PostMapping("/user/customers/new")
    public String createNewCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new-customer";
        }else{
            Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            Optional<Customer> customer = customerRepository.findByFirstNameAndEmail(customerDTO.getFirstName(), customerDTO.getEmail());
            List<User> users = userRepository.findAllByCompany(user.get().getCompany());
            Optional<Company> company = companyRepository.findByListOfUser(users);

            if(user.isPresent()){
                Customer newCustomer = Converter.fromCustomerDTO(customerDTO);
                newCustomer.setCompany(company.get());

                if(customer.isPresent()){
                    newCustomer.setIdCustomer(customer.get().getIdCustomer());
                    newCustomer.setCompany(company.get());
                }
                customerRepository.save(newCustomer);
            }
        }
        return "redirect:/user/customers";
    }

    @GetMapping("/user/customers")
    public String getCustomersPage(Model model){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<User> users = userRepository.findAllByCompany(user.get().getCompany());
        Optional<Company> company = companyRepository.findByListOfUser(users);
        if(user.isPresent()){
            model.addAttribute("customers", customerRepository.findAllByCompany(company.get()));
        }
        return "customers";
    }

    @GetMapping("/user/customers/{customerId}/edit")
    public String getEditCustomerPage(@PathVariable long customerId, Model model, CustomerDTO customerDTO){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Customer> customer = customerRepository.findById(customerId);

        if(user.isPresent()){
            customerDTO = Converter.toCustomerDTO(customer.get());
            model.addAttribute("customerDTO", customerDTO);
        }
        return "edit-customer";
    }

    @PostMapping("/user/customers/{customerId}/edit")
    public String editCustomerById(@PathVariable long customerId, CustomerDTO customerDTO){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<User> users = userRepository.findAllByCompany(user.get().getCompany());
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Company> company = companyRepository.findByListOfUser(users);
        Customer editCustomer = customer.get();

        if(user.isPresent()){
            editCustomer = Converter.fromCustomerDTO(customerDTO);
            editCustomer.setCompany(company.get());
            customerRepository.save(editCustomer);
        }
        return "redirect:/user/customers";
    }

    @GetMapping("/user/customers/{customerId}/delete")
    public String deleteCustomerById(@PathVariable long customerId){
        if(customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        }
        return "redirect:/user/customers";
    }
}
