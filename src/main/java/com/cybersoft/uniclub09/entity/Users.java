package com.cybersoft.uniclub09.entity;

import jakarta.persistence.*;
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

    @Column(name = "create_date")
    private LocalDateTime createdDate;
}
