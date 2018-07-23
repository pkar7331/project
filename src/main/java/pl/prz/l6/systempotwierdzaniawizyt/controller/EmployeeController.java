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
import pl.prz.l6.systempotwierdzaniawizyt.DTO.EmployeeDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.Employee;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CompanyRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.EmployeeRepository;
import pl.prz.l6.systempotwierdzaniawizyt.service.AdminService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {

    public final EmployeeRepository employeeRepository;
    public final AdminService adminService;
    public final CompanyRepository companyRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, AdminService adminService, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.adminService = adminService;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/admin/companies/{companyId}/edit/employees/new")
    public String getNewEmployeePage(EmployeeDTO employeeDTO){return "new-employee";}

    @PostMapping("admin/companies/{companyId}/edit/employees/new")
    public String createNewEmployee(@PathVariable long companyId, @Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new-employee";
        }else{
            Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            Optional<Employee> employee = employeeRepository.findByFirstName(employeeDTO.getFirstName());
            Optional<Company> company = companyRepository.findById(companyId);

            if(admin.isPresent()){
                Employee newEmployee = Converter.fromEmployeeDTO(employeeDTO);
                newEmployee.setCompany(company.get());

                if(employee.isPresent()){
                    newEmployee.setIdEmployee(employee.get().getIdEmployee());
                    newEmployee.setCompany(company.get());
                }
                employeeRepository.save(newEmployee);
            }
        }
        return "redirect:/admin/companies/{companyId}/edit/employees";
    }

    @GetMapping("/admin/companies/{companyId}/edit/employees")
    public String getEmployeesList(@PathVariable long companyId, Model model){
        Optional<Admin> admin = adminService.findAdminByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Company> company = companyRepository.findById(companyId);

        if(admin.isPresent()){
            model.addAttribute("employees", employeeRepository.findAllByCompanyName(company.get().getName()));
        }
        return "employees";
    }

    @GetMapping("/admin/companies/{companyId}/edit/employees/{employeeId}/edit")
    public String showEditEmployeePage(@PathVariable long companyId, @PathVariable long employeeId, Model model, EmployeeDTO employeeDTO){
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<Employee> employee = employeeRepository.findByIdEmployeeAndCompany(employeeId, company.get());
        if(employee.isPresent()){

            employeeDTO = Converter.toEmployeeDTO(employee.get());

            model.addAttribute("employeeDTO", employeeDTO);
        }
        return "edit-employee";
    }

    @PostMapping("/admin/companies/{companyId}/edit/employees/{employeeId}/edit")
    public String editEmployeeById(@PathVariable long companyId, @PathVariable long employeeId, EmployeeDTO employeeDTO){
        Optional<Company> company = companyRepository.findById(companyId);
        Optional<Employee> employee = employeeRepository.findByIdEmployeeAndCompany(employeeId, company.get());
        Employee editEmployee = employee.get();

        if(company.isPresent()){
            editEmployee = Converter.fromEmployeeDTO(employeeDTO);
            editEmployee.setCompany(company.get());
            employeeRepository.save(editEmployee);
        }
        return "redirect:/admin/companies/{companyId}/edit/employees";
    }

    @GetMapping("/admin/companies/{companyId}/edit/employees/{employeeId}/delete")
    public String deleteEmployeeById(@PathVariable long companyId, @PathVariable long employeeId){
        if(companyRepository.existsById(companyId)){
            if(employeeRepository.existsById(employeeId)){
                employeeRepository.deleteById(employeeId);
            }
        }
        return "redirect:/admin/companies/{companyId}/edit/employees";
    }
}
