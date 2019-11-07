package com.cheraten.lr4.controller;

import com.cheraten.lr4.model.LoginPassword;

import com.cheraten.lr4.service.LoginPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    LoginPasswordService loginPasswordService;

    @RequestMapping("/list")
    public ModelAndView homeGet() {

        List<LoginPassword> users = (List<LoginPassword>) loginPasswordService.findAll();
        ModelAndView modelAndView = new ModelAndView("hello.jsp");
        modelAndView.addObject("users", users);
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

        loginPasswordService.saveLoginPassword(loginPassword);
        modelAndView.addObject("loginPassword", new LoginPassword());

        modelAndView.setViewName("registration.jsp");

        return modelAndView;
    }
}
