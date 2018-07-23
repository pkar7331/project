package pl.prz.l6.systempotwierdzaniawizyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.l6.systempotwierdzaniawizyt.model.AttributePattern;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributePatternRepository extends JpaRepository<AttributePattern, Long> {
    Optional<AttributePattern> findByName(String name);
    Optional<AttributePattern> findByIdAttributePatternAndCompany(long id, Company company);
    List<AttributePattern> findAllByCompanyName(String companyName);
}
