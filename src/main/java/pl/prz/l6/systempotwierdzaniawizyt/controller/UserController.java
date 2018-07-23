package pl.prz.l6.systempotwierdzaniawizyt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getCalendarPage(){
        return "calendar";
    }



}
