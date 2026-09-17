package com.areeb.foodDeliveryApp.reviews.repository;

import com.areeb.foodDeliveryApp.reviews.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

    List<Review> findByMenu_IdOrderByCreatedAtDesc(Long menuId);

    @Query("""
            SELECT AVG(r.rating)
            FROM Review r
            WHERE r.menu.id = :menuId
            """)
    Double calculateAverageRating(@Param("menuId") Long menuId);

    boolean existsByUser_IdAndMenu_Id(Long userId, Long menuId);
}