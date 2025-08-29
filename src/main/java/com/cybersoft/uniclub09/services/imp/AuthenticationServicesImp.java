package com.cybersoft.uniclub09.services.imp;

import com.cybersoft.uniclub09.entity.Users;
import com.cybersoft.uniclub09.repository.UserRepository;
import com.cybersoft.uniclub09.services.AuthenticaticationServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImp  implements AuthenticaticationServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean checkLogin(String email, String password) {
        boolean isSuccess = false;
        Optional<Users> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            Users user = optionalUser.get();
            if(passwordEncoder.matches(password, user.getPassword())){
               isSuccess = true;
            }

        }

        return false;
    }
}
