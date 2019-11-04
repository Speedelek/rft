package com.buffet.buffet.service;

import com.buffet.buffet.entities.registration.Role;
import com.buffet.buffet.entities.registration.User;
import com.buffet.buffet.repository.RoleRepository;
import com.buffet.buffet.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService  {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        User user = findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void registerUser(User userToRegister) {
		/*User userCheck = userRepository.findByEmail(userToRegister.getEmail());

		if (userCheck != null)
			return "alreadyExists";*/

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