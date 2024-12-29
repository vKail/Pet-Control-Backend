package com.jurado.adrian.petcontrol.user.adapter.in.web;

import com.jurado.adrian.petcontrol.user.application.dto.UserDTO;
import com.jurado.adrian.petcontrol.user.application.port.in.IRegisterUser;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final IRegisterUser registerUser;
    public UserController(IRegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody UserDTO user) {
        return registerUser.registerUser(user);
    }
}
