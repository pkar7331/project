package pl.prz.l6.systempotwierdzaniawizyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByFirstName(String firstName);
    Optional<Employee> findByIdEmployeeAndCompany(long id, Company company);
    List<Employee> findAllByCompanyName(String companyName);
    List<Employee> findAllByCompany(Company company);
}
