package com.ecommerce.ecommerceapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.UserRepo;
import com.ecommerce.ecommerceapplication.model.User;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return user;
    }

     

}
