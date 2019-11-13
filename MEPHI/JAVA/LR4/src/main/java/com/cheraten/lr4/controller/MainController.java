package com.cheraten.lr4.controller;

import com.cheraten.lr4.model.LoginPassword;

import com.cheraten.lr4.service.LoginPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    LoginPasswordService loginPasswordService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        LoginPassword loginPassword = new LoginPassword();

        modelAndView.setViewName("login.jsp");
        modelAndView.addObject("loginPassword", loginPassword);

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView authentication(@ModelAttribute("loginPassword") LoginPassword loginPassword) {
        ModelAndView modelAndView = new ModelAndView();

        if (loginPasswordService.existsByLogin(loginPassword.getLogin())) {
            if(loginPasswordService.findByLogin(loginPassword.getLogin()).getPassword().equals(loginPassword.getPassword())) {
                List<LoginPassword> users = (List<LoginPassword>) loginPasswordService.findAll();
                modelAndView.addObject("users", users);
                modelAndView.setViewName("hello.jsp");
            }
            else {
                modelAndView.setViewName("login.jsp");
                String authError = "Login or password invalid! Please verify.";
                modelAndView.addObject("authError", authError);
            }
        }
        else{
            modelAndView.setViewName("login.jsp");
            String notContainError = "User doesn't exist!";
            modelAndView.addObject("notContainError", notContainError);
        }
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        LoginPassword loginPassword = new LoginPassword();

        modelAndView.setViewName("registration.jsp");

        modelAndView.addObject("loginPassword", loginPassword);

        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("loginPassword") LoginPassword loginPassword) {
        ModelAndView modelAndView = new ModelAndView();

        if(loginPasswordService.existsByLogin(loginPassword.getLogin())) {
            modelAndView.setViewName("registration.jsp");
            String regError = "This login is busy!";
            modelAndView.addObject("regError", regError);
        } else {
            loginPasswordService.saveLoginPassword(loginPassword);
            modelAndView.addObject("loginPassword", new LoginPassword());
            modelAndView.setViewName("registration.jsp");
            String regMessage = "New user created! Now sign up to view the list of registered users.";
            modelAndView.addObject("regMessage", regMessage);
        }
        return modelAndView;
    }
}
