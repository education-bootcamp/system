package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.repo.UserRepo;
import com.devstack.healthcare.system.repo.UserRoleHasUserRepo;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl {
    private final UserRepo userRepo;
    private final UserRoleHasUserRepo userRoleHasUserRepo;

    public ApplicationUserServiceImpl(UserRepo userRepo, UserRoleHasUserRepo userRoleHasUserRepo) {
        this.userRepo = userRepo;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
    }
}
