package com.buffet.buffet.controller;

import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.service.BuffetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private BuffetService buffetService;

    @Autowired
    public void setBuffetService(BuffetService buffetService){ this.buffetService = buffetService; }

    @RequestMapping("")
    public String home(Model model){
        model.addAttribute("pageTitle", "Test title");
        model.addAttribute("footerText", "testFooter");
        //model.addAttribute("buffets", buffetService.getBuffetEntities());
        return "home";
    }

    @RequestMapping("/buffet")
    public String buffet(Model model){
        model.addAttribute("buffets", buffetService.getBuffetEntities());
        return "buffet";
    }

    @RequestMapping("/products")
    public String products(){
        return "products";
    }


    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }


    @RequestMapping("/admin_page")
    public String adminPage(){
        return "admin_page";
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String greetingSubmit(@ModelAttribute User user) {
        System.out.println("UJ USER");
       // System.out.println(user.getUsername() + " --- " + user.getPassword());
//		log.debug(user.getUsername());
//		log.debug(user.getPassword());
        return "auth/login";
    }

   /* @RequestMapping("/name/{name}")
    public String searchForBuffet(@PathVariable(value = "name") String name,Model model)throws Exception{
        if(name == null) throw new Exception("Buffet not found");
        model.addAttribute("buffet", buffetService.getBuffetByName(name));
        return "buffet";
    }*/

}
