package com.buffet.buffet.service;

import com.buffet.buffet.entities.registration.Role;
import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.repository.RoleRepository;
import com.buffet.buffet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private final String USER_ROLE = "USER";

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);}

    @Override
    public void updateUser(User user){
        userRepository.saveAndFlush(user);
    }

    @Override
    public void userCheck(User user){
        if(user.getEmail() == "")
            user.setEmail(null);
        if(user.getPassword() == "")
            user.setPassword(null);
        if(user.getUsername() == "")
            user.setUsername(null);
        if(user.getFullname() == "")
            user.setFullname(null);
        if(user.getPhone_number() == "")
            user.setPhone_number(null);
        if(user.getAddress() == "")
            user.setAddress(null);
        if(user.getRemark() == "")
            user.setRemark(null);
        if(user.getBirth_date() == "")
            user.setBirth_date(null);
    }

    @Override
    public void registerUser(User userToRegister) {
		/*User userCheck = userRepository.findByEmail(userToRegister.getEmail());

		if (userCheck != null)
			return "emailExists";*/

        Role userRole = roleRepository.findByRole(USER_ROLE);
        if (userRole != null) {
            userToRegister.getRoles().add(userRole);
        } else {
            userToRegister.addRoles(USER_ROLE);
        }

        //userToRegister.setEnabled(false);
        //userToRegister.setActivation(generateKey());
        User u = userRepository.save(userToRegister);


        //return "ok";
    }





}