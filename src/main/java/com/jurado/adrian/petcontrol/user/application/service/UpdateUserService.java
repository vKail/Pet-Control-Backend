package com.jurado.adrian.petcontrol.user.application.service;

import com.jurado.adrian.petcontrol.user.application.dto.UserDTO;
import com.jurado.adrian.petcontrol.user.application.port.in.IUpdateUser;
import com.jurado.adrian.petcontrol.user.application.port.out.IFindUserPort;
import com.jurado.adrian.petcontrol.user.application.port.out.IUpdateUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements IUpdateUser {
    private IFindUserPort findUser;
    private IUpdateUserPort updateUser;

    public UpdateUserService(IFindUserPort findUser, IUpdateUserPort updateUser) {
        this.findUser = findUser;
        this.updateUser = updateUser;
    }

    @Override
    public User updateUser(Long id, UserDTO user) {
        User userToUpdate = findUser.findById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());

        return updateUser.updateUser(userToUpdate);
    }
}
