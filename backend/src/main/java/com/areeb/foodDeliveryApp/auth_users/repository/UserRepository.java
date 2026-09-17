package com.areeb.foodDeliveryApp.auth_users.repository;

import com.areeb.foodDeliveryApp.auth_users.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

// Import User from your project's entity package.

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}