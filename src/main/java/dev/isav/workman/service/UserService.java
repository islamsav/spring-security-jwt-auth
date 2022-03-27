package dev.isav.workman.service;

import dev.isav.workman.entity.user.RoleEntity;
import dev.isav.workman.entity.user.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String username, String roleName);
    UserEntity getUser(String username);
    List<UserEntity> getUsers();
}
