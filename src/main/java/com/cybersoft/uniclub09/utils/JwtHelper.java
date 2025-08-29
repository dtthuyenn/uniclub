package com.cybersoft.uniclub09.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component

public class JwtHelper {

    @Value("${jwt.private-key}")
    private String secretKey;

    public  String generateToken(String data){

        //muốn có được token thì cần có key để mã hóa
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        return Jwts.builder().subject(data).signWith(key).compact();



    }


}
