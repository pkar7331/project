package pl.prz.l6.systempotwierdzaniawizyt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.AdminDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.CompanyDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.exceptions.NotFoundException;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CompanyRepository;
import pl.prz.l6.systempotwierdzaniawizyt.service.AdminService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AdminController {

    private final AdminService adminService;
    private final CompanyRepository companyRepository;

    @Autowired
    public AdminController(AdminService adminService, CompanyRepository companyRepository){
        this.adminService=adminService;
        this.companyRepository=companyRepository;
    }


    @GetMapping("/sign-up")
    public String showSignUpPage(AdminDTO adminDTO){
       return "sign-up";
   }

    @PostMapping("/sign-up")
    public String createAdmin(@Valid @ModelAttribute AdminDTO adminDTO, BindingResult result){
        if(result.hasErrors()){
            return "sign-up";
        }else{
            Admin admin = new Admin();
            admin.setEmail(adminDTO.getEmail());
            admin.setPassword(adminDTO.getPassword());
            admin.setRole("ROLE_ADMIN");

            adminService.save(admin);
            //TODO DODAc widok potwierdzania zarejestrowania administratora
            return "redirect:/admin";
        }
    }
    @PostMapping("/admin/resetpaswd")
    public String resetPassword(@Valid @ModelAttribute AdminDTO adminDTO, BindingResult result){
        if(result.hasErrors()){
            return "reset-password";
        }else{
            Optional<Admin> admin = adminService.findAdminByEmail(adminDTO.getEmail());

            admin.get().setPassword(adminDTO.getPassword());
            adminService.save(admin.get());
        }
        //todo dodac potwierdzenie zmiany hasla
        return "/admin";
    }

    @GetMapping("/admin")
    public String getAdminPanelPage(){
        return "admin";
    }

    @GetMapping("/admin/companies/new")
    public String getAddCompanyPage(CompanyDTO companyDTO){
        return "new-company";
    }

    @PostMapping("/admin/companies/new")
    public String createNewCompanyDetails(@Valid @ModelAttribute CompanyDTO companyDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new-company";
        }else{
            Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

            Optional<Company> company = companyRepository.findByName(companyDTO.getName());
            if(admin.isPresent()){
                Company newCompany = Converter.fromCompanyDTO(companyDTO);
                newCompany.setAdmin(admin.get());

                if(company.isPresent()){
                    newCompany.setIdCompany(company.get().getIdCompany());
                    newCompany.setAdmin(admin.get());
                }
                companyRepository.save(newCompany);
            }
            //todo mozna dodac obsluge w przypadku pojawienia sie bledu
        }
        return "redirect:/admin/companies";
    }

    @GetMapping("/admin/companies")
    public String getCompanyList(Model model){
        Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if(admin.isPresent()){
            model.addAttribute("companies", companyRepository.findAllByAdmin(admin.get()));
        }
        return "companies";
    }

    @GetMapping("/admin/companies/{id}/delete")
    public String deleteCompanyById(@PathVariable long id){
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
        }
        return "redirect:/admin/companies";
    }

    @GetMapping("/admin/companies/{id}/edit")
    public String editUserById(@PathVariable("id")long id, Model model, CompanyDTO companyDTO){
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){

            companyDTO = Converter.toCompanyDTO(company.get());

            model.addAttribute("companyDTO", companyDTO);
            return "edit-company";
        }
        return "redirect:/admin/companies";
    }

    @GetMapping("/admin/resetpaswd")
    public String getResetPasswordPage(AdminDTO adminDTO, Model model) throws Exception{
        Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if(admin.isPresent()){
            adminDTO.setEmail(admin.get().getEmail());
            model.addAttribute("adminDTO", adminDTO);
        }else{
            throw new NotFoundException("User not found!");
        }
        return "reset-password";
    }
}
