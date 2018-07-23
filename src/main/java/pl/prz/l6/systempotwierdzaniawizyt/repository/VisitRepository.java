package pl.prz.l6.systempotwierdzaniawizyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.Visit;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByStartIsBetweenAndCompany(Timestamp start, Timestamp end, Company company);
    List<Visit> findAllByCompany(Company company);
    Optional<Visit> findByToken(String token);
}
