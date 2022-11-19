package com.dansmulticorp.repository;

import com.dansmulticorp.repository.models.ERole;
import com.dansmulticorp.repository.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
