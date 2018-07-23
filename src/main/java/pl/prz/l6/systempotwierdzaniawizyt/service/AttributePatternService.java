package pl.prz.l6.systempotwierdzaniawizyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.model.AttributePattern;
import pl.prz.l6.systempotwierdzaniawizyt.repository.AttributePatternRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AttributePatternService {

    private final AttributePatternRepository attributePatternRepository;

    @Autowired
    public AttributePatternService(AttributePatternRepository attributePatternRepository) {
        this.attributePatternRepository = attributePatternRepository;
    }

// TODO to co widac ponizej
    public Optional<AttributePattern> findAttributePatternByName(String name){
        return attributePatternRepository.findByName(name);
    }//trzeba ogarnac po czym szukac

}
