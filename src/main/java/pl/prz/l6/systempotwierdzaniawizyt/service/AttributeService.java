package pl.prz.l6.systempotwierdzaniawizyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.model.Attribute;
import pl.prz.l6.systempotwierdzaniawizyt.repository.AttributeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }
// TODO to co widac ponizej
//    @Transactional
//    public Optional<Attribute> findAttributeBy*(string? *)//trzeba ogarnac po czym szukac
//      return attributeRepository.findBy*(*);
}
