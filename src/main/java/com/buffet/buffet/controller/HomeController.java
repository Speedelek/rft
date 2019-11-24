package com.buffet.buffet.controller;

import com.buffet.buffet.entities.Product;
import com.buffet.buffet.entities.registration.Role;
import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.repository.UserRepository;
import com.buffet.buffet.service.BuffetService;
import com.buffet.buffet.service.ProductService;
import com.buffet.buffet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private BuffetService buffetService;
    private UserService userService;
    private ProductService productService;
    private UserRepository userRepository;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBuffetService(BuffetService buffetService) {
        this.buffetService = buffetService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String home() {

        return "home";
    }

    @RequestMapping("/buffet")
    public String buffet(Model model) {
        model.addAttribute("buffets", buffetService.getBuffetEntities());
        return "buffet";
    }

    @RequestMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        // model.addAttribute("user", userService.findByUsername(username));
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping("/profile_edit")
    public String profileEdit(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = (User) userService.findByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile_edit";
    }

    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal UserDetails currentUser, HttpServletRequest request, HttpServletResponse response) {
        User user = (User) userService.findByUsername(currentUser.getUsername());
        // usersRoleSercive.deleteUsersRole(user);
        Long id = user.getId();
        userService.deleteById(Long.valueOf(id));
        System.out.println("delete" + user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "auth/login";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user, @AuthenticationPrincipal UserDetails currentUser, Model model, BindingResult bindingResult) {
        User currUser = (User) userService.findByUsername(currentUser.getUsername());
        if (user.getPassword() == "") {
            model.addAttribute("errorMessage", "Adj meg egy jelszót");
            bindingResult.reject("password");
            System.out.println("jelszo");
        }
        if (bindingResult.hasErrors()) {
            return "profile_edit";
        } else {
            userService.deleteById(Long.valueOf(currUser.getId()));
            userService.userCheck(user);
            userService.updateUser(user);
            return "profile";
        }
    }


    @RequestMapping("/admin_page")
    public String adminPage() {
        return "admin_page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String reg(ModelAndView modelAndView, Model model, @Valid User user, BindingResult bindingResult) {
        User userCheck = userRepository.findByEmail(user.getEmail());
        User userCheck2 = userRepository.findByUsername(user.getUsername());
        if (userCheck != null) {
            System.out.println("hiba email");
            model.addAttribute("errorMessage", "Már létezik ilyen email cím");
            bindingResult.reject("email");
            //return "registration";
        }
        if (userCheck2 != null) {
            System.out.println("hiba username");
            model.addAttribute("errorMessage", "Már létezik ilyen felhasználó");
            bindingResult.reject("username");
            //return "registration";
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            log.info("Uj user!");
            userService.registerUser(user);
            return "auth/login";
        }
    }
    //	@RequestMapping(value = "/reg", method = RequestMethod.POST)
    /*@PostMapping("/reg")
    public String reg( ModelAndView modelAndView, Model model ,@Valid User user, BindingResult bindingResult, HttpServletRequest request) {

        User userCheck = userRepository.findByEmail(user.getEmail());
        //System.out.println("check" + userCheck);
        //System.out.println(user);
        if (userCheck != null) {
            System.out.println("hiba");
            modelAndView.addObject("errorMessage", "Oops!  There is already a user registered with the email provided.");
            return "registration";
        }

             else {
            log.info("Uj user!");
                userService.registerUser(user);
            return "auth/login";
            }

    }*/

    @RequestMapping("/buffet/{buffetId}")
    public String singleBuffet(Model model, @PathVariable(value = "buffetId") String buffetId) throws Exception {
        if (buffetId == null) throw new Exception("Nincs id");
        model.addAttribute("products", productService.getProductByBuffetId(buffetId));

        Long id = Long.parseLong(buffetId);
        model.addAttribute("actualBuffet", buffetService.getActualBuffet(id));
        return "buffetProducts";
    }

    @RequestMapping("/products/{category}")
    public String products(Model model, @PathVariable(value = "category") String category) throws Exception {
        Integer categoryInt = Integer.parseInt(category);
        model.addAttribute("products", productService.getProductByKategoria(categoryInt));
        return "products";
    }
}