package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.dto.request.RequestUserDto;
import com.devstack.healthcare.system.entity.UserRole;
import com.devstack.healthcare.system.entity.UserRoleHasUser;
import com.devstack.healthcare.system.repo.UserRoleHasUserRepo;
import com.devstack.healthcare.system.repo.UserRoleRepo;
import com.devstack.healthcare.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepo userRoleRepo;
    private final UserRoleHasUserRepo userRoleHasUserRepo;

    @Autowired
    public UserServiceImpl(UserRoleRepo userRoleRepo, UserRoleHasUserRepo userRoleHasUserRepo) {
        this.userRoleRepo = userRoleRepo;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
    }

    @Override
    public void signup(RequestUserDto userDto) {
        UserRole userRole;
        if (userDto.getId()==1){
            userRole = userRoleRepo.findUserRoleByName("ADMIN");
        }else{
            userRole =  userRoleRepo.findUserRoleByName("DOCTOR");
        }

        if (userRole==null){
            throw new RuntimeException("User role not found");
        }

        UserRoleHasUser userData = new UserRoleHasUser("","");

    userRoleHasUserRepo.save();


    }
}
