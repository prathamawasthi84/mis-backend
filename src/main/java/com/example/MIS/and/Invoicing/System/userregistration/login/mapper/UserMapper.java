package com.example.MIS.and.Invoicing.System.userregistration.login.mapper;

import com.example.MIS.and.Invoicing.System.userregistration.login.dto.UserDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;

public class UserMapper {
    public UserEntity toEntity(UserDTO userDTO,String encodedPassword){
        UserEntity userEntity= new UserEntity();
        userEntity.setFull_name(userDTO.getFull_name());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword_hash(encodedPassword);
        return userEntity;
    }
    public UserDTO toResponse(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setFull_name(userEntity.getFull_name());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

}
