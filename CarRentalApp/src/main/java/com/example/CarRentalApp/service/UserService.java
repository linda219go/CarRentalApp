package com.example.CarRentalApp.service;

import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.model.UserModel;
import com.example.CarRentalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) throws RuntimeException{
        if(checkIfUserExist(user.getEmail())){
            throw new RuntimeException("User already exist");
        }
        String encodedPW = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPW);
        return userRepository.saveAndFlush(user);
    }

    public User login(String email, String password){
        User user = userRepository.findByEmailAndPassword(email,password);
        return user;
    }

    public User findUser(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    public boolean checkIfUserExist(String email){
        return userRepository.findByEmail(email) != null? true: false;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
