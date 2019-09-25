package com.fyle.starter.bank.dao;

import com.fyle.starter.bank.model.Role;
import com.fyle.starter.bank.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}