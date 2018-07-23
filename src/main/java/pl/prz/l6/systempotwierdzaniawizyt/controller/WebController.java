package pl.prz.l6.systempotwierdzaniawizyt.controller;



import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebController {

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @GetMapping("/successlogged")
    public String getDefaultPageByUserRole(HttpServletRequest request){

        if(request.isUserInRole("ROLE_USER")){
            return "redirect:/user";
        }else if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/admin";
        }else{
            return "redirect:/";
        }
    }

}
