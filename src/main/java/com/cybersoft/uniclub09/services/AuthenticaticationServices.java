package com.cybersoft.uniclub09.services;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticaticationServices {

    String checkLogin(String email, String password);
}
