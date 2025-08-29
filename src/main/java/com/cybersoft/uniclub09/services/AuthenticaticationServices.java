package com.cybersoft.uniclub09.services;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticaticationServices {

    boolean checkLogin(String email, String password);
}
