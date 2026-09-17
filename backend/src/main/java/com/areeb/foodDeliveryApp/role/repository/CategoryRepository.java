package com.areeb.foodDeliveryApp.role.repository;

import com.areeb.foodDeliveryApp.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository
        extends JpaRepository<Category, UUID> {
}