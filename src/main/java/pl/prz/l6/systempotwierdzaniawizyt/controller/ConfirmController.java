package pl.prz.l6.systempotwierdzaniawizyt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.prz.l6.systempotwierdzaniawizyt.model.Visit;
import pl.prz.l6.systempotwierdzaniawizyt.repository.*;
import pl.prz.l6.systempotwierdzaniawizyt.service.VisitService;

import java.util.Optional;

@Controller
public class ConfirmController {
    private final CustomerRepository customerRepository;
    private final VisitRepository visitRepository;
    private final UserRepository userRepository;
    private final VisitService visitService;

    @Autowired
    public ConfirmController(CustomerRepository customerRepository, VisitRepository visitRepository, UserRepository userRepository, VisitService visitService){
        this.customerRepository = customerRepository;
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
        this.visitService = visitService;
    }

    @GetMapping(value = "/confirm", params = {"token", "value"})
    public String confirmVisit(@RequestParam(value = "token") String token, @RequestParam(value = "value") String value, Model model){
        Optional<Visit> visit = visitRepository.findByToken(token);
		String confirmSuccessful = "no";

        if (visit.isPresent()) {
            if (value.equals("yes") && !visit.get().isCanceled() && !visit.get().isVerification()) {
                visit.get().setCanceled(false);
                visit.get().setVerification(true);
                confirmSuccessful = "yes";
            }
            else if (value.equals("no") && !visit.get().isCanceled() && !visit.get().isVerification()) {
                visit.get().setCanceled(true);
                visit.get().setVerification(false);
                confirmSuccessful = "yes";
            }
            visitService.save(visit.get());
        }
        
        model.addAttribute("confirmSuccessful", confirmSuccessful);
		model.addAttribute("confirmValue", value);
        return "confirm-successful";
    }
}
