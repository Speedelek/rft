package com.buffet.buffet.controller;

import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.service.BuffetService;
import com.buffet.buffet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BuffetService buffetService;
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBuffetService(BuffetService buffetService){ this.buffetService = buffetService; }


    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/buffet")
    public String buffet(Model model){
        model.addAttribute("buffets", buffetService.getBuffetEntities());
        System.out.println(model.addAttribute("buffets", buffetService.getBuffetEntities()));
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

    //	@RequestMapping(value = "/reg", method = RequestMethod.POST)
    @PostMapping("/reg")
    public String reg(@ModelAttribute User user) {
        log.info("Uj user!");
//		emailService.sendMessage(user.getEmail());
        log.debug(user.getFullName());
        log.debug(user.getEmail());
        log.debug(user.getPassword());
        userService.registerUser(user);
        return "auth/login";
    }

	/* @RequestMapping(path = "/activation/{code}", method = RequestMethod.GET)
	    public String activation(@PathVariable("code") String code, HttpServletResponse response) {
		String result = userService.userActivation(code);
		return "auth/login";
	 }*/

}
