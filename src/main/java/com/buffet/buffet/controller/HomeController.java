package com.buffet.buffet.controller;

import com.buffet.buffet.repository.BuffetRepository;
import com.buffet.buffet.service.BuffetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private BuffetService buffetService;

    @Autowired
    public void setBuffetService(BuffetService buffetService){ this.buffetService = buffetService; }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle", "Test title");
        model.addAttribute("footerText", "testFooter");
        //model.addAttribute("buffets", buffetService.getBuffetEntities());
        model.addAttribute("buffets", buffetService.getBuffetEntities());
        return "home";
    }

}
