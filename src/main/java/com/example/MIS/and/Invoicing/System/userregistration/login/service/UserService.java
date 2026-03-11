package com.example.MIS.and.Invoicing.System.userregistration.login.service;

import com.example.MIS.and.Invoicing.System.userregistration.login.config.SecurityConfig;
import com.example.MIS.and.Invoicing.System.userregistration.login.dto.UserDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.mapper.UserMapper;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserEntity userEntity;
    private final UserDTO userDTO;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserEntity userEntity,UserRepository userRepository,PasswordEncoder passwordEncoder,UserDTO userDTO,UserMapper userMapper){
        this.userEntity=userEntity;
        this.userDTO=userDTO;
        this.userMapper=userMapper;
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public UserEntity saveUser(UserDTO userDTO){
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword_hash());
        UserEntity user = userMapper.toEntity(userDTO,encodedPassword);
        if(userRepository.existsByEmail(userEntity.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(userEntity);
    }
}
