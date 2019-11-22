package com.buffet.buffet.controller;

import com.buffet.buffet.entities.registration.Role;
import com.buffet.buffet.entities.registration.User;
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
    public String profileEdit(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile_edit";
    }

    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) userService.findByUsername(currentUser.getUsername());
       // usersRoleSercive.deleteUsersRole(user);
        Long id = user.getId();
        userService.deleteById(Long.valueOf(id));
        System.out.println("delete" + user);
        return "auth/login";
    }
    @PostMapping("/update")
    public String update( @ModelAttribute User user ,@AuthenticationPrincipal UserDetails currentUser) {
        User currUser = (User) userService.findByUsername(currentUser.getUsername());
        System.out.println("update elott" + currUser);
        userService.deleteById(Long.valueOf(currUser.getId()));
        System.out.println("delete" + currUser);
        System.out.println("user" + user);
        userService.userCheck(user);
        userService.updateUser(user);
//        currUser.setUsername(user.getUsername());
//        currUser.setEmail(user.getEmail());
//        currUser.setPassword(user.getPassword());
//        currUser.setFullname(user.getFullname());
//        currUser.setAddress(user.getAddress());
//        currUser.setBirth_date(user.getBirth_date());
//        currUser.setPhone_number(user.getPhone_number());
//        currUser.setRemark(user.getRemark());
        System.out.println("update utan" + currUser);
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