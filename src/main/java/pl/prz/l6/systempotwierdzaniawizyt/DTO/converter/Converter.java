package pl.prz.l6.systempotwierdzaniawizyt.DTO.converter;


import pl.prz.l6.systempotwierdzaniawizyt.DTO.*;
import pl.prz.l6.systempotwierdzaniawizyt.model.*;

//****************Converters sets properties without mapping and ID's*************//
public class Converter {

    public static Employee fromEmployeeDTO(EmployeeDTO employeeDTO){
        Employee employee = new Employee();

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setIdEmployee(employeeDTO.getId());

        return employee;
    }

    public static EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setId(employee.getIdEmployee());

        return employeeDTO;
    }

    public static Visit fromVisitDTO(VisitDTO visitDTO){
        Visit visit = new Visit();

        visit.setDescription(visitDTO.getDescription());
        visit.setCanceled(visitDTO.isCanceled());
        visit.setCompleted(visitDTO.isCompleted());
        visit.setTitle(visitDTO.getTitle());
        visit.setVerification(visitDTO.isVerification());
        visit.setIdVisit(visitDTO.getIdVisit());
        return visit;
    }

    public static VisitDTO toVisitDTO(Visit visit){
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setDescription(visit.getDescription());
        visitDTO.setTitle(visit.getTitle());
        visitDTO.setCanceled(visit.isCanceled());
        visitDTO.setCompleted(visit.isCompleted());
        visitDTO.setVerification(visit.isVerification());
        visitDTO.setIdVisit(visit.getIdVisit());

        return visitDTO;
    }

    public static Company fromCompanyDTO(CompanyDTO companyDTO){
        Company company = new Company();

        company.setCity(companyDTO.getCity());
        company.setDescription(companyDTO.getDescription());
        company.setFlatNumber(companyDTO.getFlatNumber());
        company.setName(companyDTO.getName());
        company.setPhone(companyDTO.getPhoneNumber());
        company.setPostCode(companyDTO.getPostCode());
        company.setStreet(companyDTO.getStreet());
        company.setIdCompany(companyDTO.getCompanyId());

        return company;
    }

    public static CompanyDTO toCompanyDTO(Company company){
        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCity(company.getCity());
        companyDTO.setDescription(company.getDescription());
        companyDTO.setFlatNumber(company.getFlatNumber());
        companyDTO.setName(company.getName());
        companyDTO.setPhoneNumber(company.getPhone());
        companyDTO.setPostCode(company.getPostCode());
        companyDTO.setStreet(company.getStreet());
        companyDTO.setCompanyId(company.getIdCompany());

        return companyDTO;
    }

    public static Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setIdCustomer(customerDTO.getCustomerId());
        customer.setComment(customerDTO.getComment());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customer;
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setComment(customer.getComment());
        customerDTO.setCustomerId(customer.getIdCustomer());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPhone(customer.getPhone());

        return customerDTO;
    }

    public static AttributePattern fromAttributePatternDTO(AttributePatternDTO attributePatternDTO){
        AttributePattern attributePattern = new AttributePattern();

        attributePattern.setIdAttributePattern(attributePatternDTO.getIdAttributePattern());
        attributePattern.setName(attributePatternDTO.getName());
        attributePattern.setRegex(attributePatternDTO.getRegex());
        attributePattern.setObligatory(attributePatternDTO.isObligatory());

        return attributePattern;
    }

    public static AttributePatternDTO toAttributePatternDTO(AttributePattern attributePattern){
        AttributePatternDTO attributePatternDTO = new AttributePatternDTO();

        attributePatternDTO.setIdAttributePattern(attributePattern.getIdAttributePattern());
        attributePatternDTO.setName(attributePattern.getName());
        attributePatternDTO.setRegex(attributePattern.getRegex());
        attributePatternDTO.setObligatory(attributePattern.isObligatory());

        return attributePatternDTO;
    }

}
