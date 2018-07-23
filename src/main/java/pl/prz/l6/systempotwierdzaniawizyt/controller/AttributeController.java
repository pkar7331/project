package pl.prz.l6.systempotwierdzaniawizyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.prz.l6.systempotwierdzaniawizyt.service.AttributeService;

@Controller
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }


}
