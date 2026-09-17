package com.areeb.foodDeliveryApp.role.repository;

import com.areeb.foodDeliveryApp.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(String name);
}