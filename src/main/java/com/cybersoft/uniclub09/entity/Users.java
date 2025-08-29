package com.cybersoft.uniclub09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.cache.annotation.EnableCaching;

import java.time.LocalDateTime;

@Entity(name="users")
@Data
public class Users {

    @Id
    private String id;
    private String email;
    private String password;

    private LocalDateTime createdDate;
}
