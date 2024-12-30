package com.jurado.adrian.petcontrol.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String phone;

    public User(String username, String password, String email, String phone, String name, String lastname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
