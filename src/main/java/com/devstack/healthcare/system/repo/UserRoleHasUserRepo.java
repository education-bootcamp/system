package com.devstack.healthcare.system.repo;

import com.devstack.healthcare.system.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRoleHasUserRepo extends JpaRepository<UserRole,Long> {
}
