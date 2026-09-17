package com.areeb.foodDeliveryApp.menu.repository;

import com.areeb.foodDeliveryApp.menu.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

// Import Menu from your project's entity package.

public interface MenuRepository
        extends JpaRepository<Menu, UUID>,
        JpaSpecificationExecutor<Menu> {
}