package com.jurado.adrian.petcontrol.user.application.service;

import com.jurado.adrian.petcontrol.user.application.port.in.IFindUser;
import com.jurado.adrian.petcontrol.user.application.port.out.IFindUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class FindUserService implements IFindUser {
    private final IFindUserPort findUserPort;
    public FindUserService(IFindUserPort findUserPort) {
        this.findUserPort = findUserPort;
    }
    @Override
    public User findById(Long id) {
        return findUserPort.findById(id);
    }
}
