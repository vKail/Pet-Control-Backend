package com.jurado.adrian.petcontrol.user.adapter.out.persistence;

import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastname(userEntity.getLastname());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setPhone(userEntity.getPhone());
        return user;
    }

    public UserEntity toUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setLastname(user.getLastname());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        return userEntity;
    }
}
