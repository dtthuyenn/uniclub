package com.cybersoft.uniclub09.services.imp;

import com.cybersoft.uniclub09.entity.Users;
import com.cybersoft.uniclub09.repository.UserRepository;
import com.cybersoft.uniclub09.services.AuthenticaticationServices;
import com.cybersoft.uniclub09.utils.JwtHelper;
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

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public String checkLogin(String email, String password) {
        Optional<Users> optional = userRepository.findByEmail(email);
        if (optional.isPresent()) {
            Users user = optional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return jwtHelper.generateToken(user.getEmail());
            }
        }
        // Đăng nhập thất bại (không tìm thấy người dùng hoặc sai mật khẩu)
        return null; // Trả về null hoặc một chuỗi rỗng để báo hiệu thất bại
    }
}
