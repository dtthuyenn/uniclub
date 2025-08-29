package com.cybersoft.uniclub09.controller;

import com.cybersoft.uniclub09.payload.response.BaseResponse;
import com.cybersoft.uniclub09.services.imp.AuthenticationServicesImp;
import com.cybersoft.uniclub09.utils.JwtHelper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationServicesImp authenticationServicesImp;

    @Autowired
    private JwtHelper jwtHelper;
    /*
    {
        Bộ BaseResponse chung
        thông qua status code sẽ phân biệt status code 200 tức là server
         đã xử lý nghiệp vụ xong truy vấn tất tần tật đã trả dữ liệu

        Bộ mã status code
        "code": 200,
        "message": "Login successful"
        "data": [] linh động tùy vào api  mình muốn trả ra là gì

    }
     */

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestParam String email,
                                    @RequestParam String password) {

//        SecretKey key = Jwts.SIG.HS256.key().build(); //or HS384.key() or HS512.key()
//        String secretString = Encoders.BASE64.encode(key.getEncoded());

        String token = authenticationServicesImp.checkLogin(email, password);

        BaseResponse response = new BaseResponse();

        if (token != null && !token.isEmpty()) {
            // Đăng nhập thành công
            response.setCode(HttpStatus.OK.value());
            response.setMessage("Login successful");
            response.setData(token); // Trả về token trong trường data
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Đăng nhập thất bại
            response.setCode(HttpStatus.UNAUTHORIZED.value()); // Mã HTTP 401
            response.setMessage("Invalid email or password");
            response.setData(null); // Không có dữ liệu khi đăng nhập thất bại
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}



