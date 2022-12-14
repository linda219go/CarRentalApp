package com.example.CarRentalApp.service;

import com.example.CarRentalApp.CustomUserDetails;
import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("user not exist");
        }
        return new CustomUserDetails(user);
    }


}
