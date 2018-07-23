package pl.prz.l6.systempotwierdzaniawizyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.AttributePatternDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.model.AttributePattern;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.User;
import pl.prz.l6.systempotwierdzaniawizyt.repository.AttributePatternRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CompanyRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.UserRepository;
import pl.prz.l6.systempotwierdzaniawizyt.service.AdminService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AttributePatternController {

    private final AttributePatternRepository attributePatternRepository;
    private final CompanyRepository companyRepository;
    private final AdminService adminService;
    private final UserRepository userRepository;

    @Autowired
    public AttributePatternController(AttributePatternRepository attributePatternRepository, CompanyRepository companyRepository, AdminService adminService, UserRepository userRepository) {
        this.attributePatternRepository = attributePatternRepository;
        this.companyRepository = companyRepository;
        this.adminService = adminService;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/companies/{companyId}/edit/attribute-patterns/new")
    public String getNewAttributePatternPage(AttributePatternDTO attributePatternDTO){return "new-attribute-pattern";}

    @PostMapping("/admin/companies/{companyId}/edit/attribute-patterns/new")
    public String createNewAttributePattern(@PathVariable String companyId, @Valid @ModelAttribute AttributePatternDTO attributePatternDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "new-attribute-pattern";
        }else{
            Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            Optional<AttributePattern> attributePattern = attributePatternRepository.findByName(attributePatternDTO.getName());
            Optional<Company> company = companyRepository.findById(Long.valueOf(companyId));
            Optional<User> user = userRepository.findByCompany(company.get());

            if(admin.isPresent()){
                AttributePattern newAttributePattern = Converter.fromAttributePatternDTO(attributePatternDTO);
                newAttributePattern.setCompany(company.get());
                newAttributePattern.setUser(user.get());

                if(attributePattern.isPresent()){
                    newAttributePattern.setIdAttributePattern(attributePattern.get().getIdAttributePattern());
                    newAttributePattern.setCompany(company.get());
                    newAttributePattern.setUser(user.get());
                }
                attributePatternRepository.save(newAttributePattern);
            }
        }
        return "redirect:/admin/companies/{companyId}/edit/attribute-patterns";
    }

    @GetMapping("/admin/companies/{companyId}/edit/attribute-patterns")
    public String showAttributePatternsList(@PathVariable long companyId, Model model){
        Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Company> company = companyRepository.findById(companyId);

        if(admin.isPresent()){
            model.addAttribute("attributePatterns", attributePatternRepository.findAllByCompanyName(company.get().getName()));
        }
        return "attribute-patterns";
    }

    @GetMapping("/admin/companies/{companyId}/edit/attribute-patterns/{attrPattId}/edit")
    public String showEditAttributePatternPage(@PathVariable long companyId, @PathVariable long attrPattId, Model model, AttributePatternDTO attributePatternDTO){
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<AttributePattern> attributePattern = attributePatternRepository.findByIdAttributePatternAndCompany(attrPattId, company.get());

        if(attributePattern.isPresent()){
            attributePatternDTO = Converter.toAttributePatternDTO(attributePattern.get());
            model.addAttribute("attributePatternDTO", attributePatternDTO);
        }
        return "edit-attribute-pattern";
    }

    @PostMapping("/admin/companies/{companyId}/edit/attribute-patterns/{attrPattId}/edit")
    public String editAttributePatternById(@PathVariable long companyId, @PathVariable long attrPattId, AttributePatternDTO attributePatternDTO){
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<AttributePattern> attributePattern = attributePatternRepository.findByIdAttributePatternAndCompany(attrPattId, company.get());
        Optional<User> user = userRepository.findByCompany(company.get());
        AttributePattern editAttributePattern = attributePattern.get();

        if(company.isPresent()){
            editAttributePattern = Converter.fromAttributePatternDTO(attributePatternDTO);
            editAttributePattern.setCompany(company.get());
            editAttributePattern.setUser(user.get());
            attributePatternRepository.save(editAttributePattern);
        }

        return "redirect:/admin/companies/{companyId}/edit/attribute-patterns";
    }

    @GetMapping("/admin/companies/{companyId}/edit/attribute-patterns/{attrPattId}/delete")
    public String deleteAttributePatternById(@PathVariable long companyId, @PathVariable long attrPattId){
        if(companyRepository.existsById(companyId)){
            if(attributePatternRepository.existsById(attrPattId)){
                attributePatternRepository.deleteById(attrPattId);
            }
        }
        return "redirect:/admin/companies/{companyId}/edit/attribute-patterns";
    }

}
