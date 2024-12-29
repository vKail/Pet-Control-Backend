package com.jurado.adrian.petcontrol.user.adapter.out.persistence;

import com.jurado.adrian.petcontrol.user.application.port.out.IFindUserPort;
import com.jurado.adrian.petcontrol.user.application.port.out.ISaveUserPort;
import com.jurado.adrian.petcontrol.user.application.port.out.IUpdateUserPort;
import com.jurado.adrian.petcontrol.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserPersistenceAdapter implements IFindUserPort, ISaveUserPort, IUpdateUserPort {
    UserRepository userRepository;
    UserMapper userMapper;
    public UserPersistenceAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public User findById(Long id) {
       return userRepository.findById(id).map(userMapper :: toDomain).orElseThrow();
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        UserEntity userToSave = userRepository.save(userEntity);
        return userMapper.toDomain(userToSave);
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        UserEntity userToUpdate = userRepository.findById(userEntity.getId()).orElseThrow();
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPhone(user.getPhone());
        userRepository.save(userToUpdate);
        return userMapper.toDomain(userToUpdate);
    }
}
