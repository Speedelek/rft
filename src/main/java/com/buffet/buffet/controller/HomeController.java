package com.buffet.buffet.controller;

import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.repository.UserRepository;
import com.buffet.buffet.service.BuffetService;
import com.buffet.buffet.service.ProductService;
import com.buffet.buffet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BuffetService buffetService;
    private UserService userService;
    private ProductService productService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBuffetService(BuffetService buffetService){ this.buffetService = buffetService; }

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }


    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/buffet")
    public String buffet(Model model){
        model.addAttribute("buffets", buffetService.getBuffetEntities());
        return "buffet";
    }

    @RequestMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails currentUser){
       // model.addAttribute("user", userService.findByUsername(username));
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping("/profile_edit")
    public String profileEdit(){
        return "profile_edit";
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
        log.debug(user.getUsername());
        log.debug(user.getEmail());
        log.debug(user.getPassword());
        userService.registerUser(user);
        return "auth/login";
    }


    @RequestMapping("/buffet/{buffetId}")
    public String singleBuffet(Model model, @PathVariable(value = "buffetId") String buffetId) throws Exception{
        if(buffetId == null) throw new Exception("Nincs id");
        model.addAttribute("products", productService.getProductByBuffetId(buffetId));

        Long id = Long.parseLong(buffetId);
        model.addAttribute("actualBuffet", buffetService.getActualBuffet(id));
        return "buffetProducts";
    }

    @RequestMapping("/products/{category}")
    public String products(Model model, @PathVariable(value = "category") String category) throws Exception{
        Integer categoryInt = Integer.parseInt(category);
        model.addAttribute("products", productService.getProductByKategoria(categoryInt));
        return "products";
    }

}