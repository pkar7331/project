package pl.prz.l6.systempotwierdzaniawizyt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.Visit;
import pl.prz.l6.systempotwierdzaniawizyt.repository.VisitRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository){
        this.visitRepository=visitRepository;
    }

    public List<Visit> findAllByStartIsBetweenAndCompany(Timestamp start, Timestamp end, Company company){
        return visitRepository.findAllByStartIsBetweenAndCompany(start, end, company );
    }

    public List<Visit> findAllByCompany(Company company){
        return visitRepository.findAllByCompany(company);
    }

    public Optional<Visit> findById(Long id){
        return visitRepository.findById(id);
    }

    public boolean existsById(long id){
        return visitRepository.existsById(id);
    }

    public void save(Visit visit){
        visitRepository.save(visit);
    }

    public void deleteById(long id){
        visitRepository.deleteById(id);
    }
}
