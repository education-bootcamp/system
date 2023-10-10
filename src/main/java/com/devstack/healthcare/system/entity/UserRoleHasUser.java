package com.devstack.healthcare.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoleHasUser {
    @EmbeddedId
    private UserRoleHasUserKey id= new UserRoleHasUserKey();

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @MapsId("userRole")
    @JoinColumn(name = "role_id",nullable = false)
    private UserRole userRole;



}
