package pl.prz.l6.systempotwierdzaniawizyt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.VisitDTO;
import pl.prz.l6.systempotwierdzaniawizyt.DTO.converter.Converter;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.model.Company;
import pl.prz.l6.systempotwierdzaniawizyt.model.User;
import pl.prz.l6.systempotwierdzaniawizyt.model.Visit;
import pl.prz.l6.systempotwierdzaniawizyt.repository.AdminRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.CompanyRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.UserRepository;
import pl.prz.l6.systempotwierdzaniawizyt.repository.VisitRepository;
import pl.prz.l6.systempotwierdzaniawizyt.service.VisitService;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CalendarRestController {

    private final VisitService visitService;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public CalendarRestController(VisitService visitService, CompanyRepository companyRepository, UserRepository userRepository, AdminRepository adminRepository){
        this.visitService=visitService;
        this.companyRepository=companyRepository;
        this.userRepository=userRepository;
        this.adminRepository=adminRepository;
    }

    @GetMapping("/get-visits")
    @ResponseBody
    public List<VisitDTO> getVisits(@RequestParam("start") String start, @RequestParam("end") String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate=null;
        Date endDate=null;

        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Company company = user.get().getCompany();
        try{
            startDate = sdf.parse(start);
            endDate = sdf.parse(end);
        }catch(ParseException e){
            //exception handle
        }

        List<Visit> listOfVisits;

        if(startDate!= null && endDate!=null && company != null){
           listOfVisits = visitService.findAllByStartIsBetweenAndCompany(new Timestamp(startDate.getTime()), new Timestamp((endDate.getTime())),company);
           List<VisitDTO> listOfVisitsDTO = new ArrayList<>();

           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

           for(Visit x:listOfVisits){
               VisitDTO newVisit = Converter.toVisitDTO(x);
                newVisit.setStart(simpleDateFormat.format(x.getStart()));
                newVisit.setEnd(simpleDateFormat.format(x.getEnd()));
                listOfVisitsDTO.add(newVisit);
           }
           return listOfVisitsDTO;

        }else {

            return null;
        }
    }
}
