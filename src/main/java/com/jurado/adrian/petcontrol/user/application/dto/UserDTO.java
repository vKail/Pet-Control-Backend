package com.jurado.adrian.petcontrol.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String username;
    private String password;
}
