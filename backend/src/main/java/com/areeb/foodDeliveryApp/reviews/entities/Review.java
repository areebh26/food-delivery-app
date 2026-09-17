package com.areeb.foodDeliveryApp.reviews.entities;

import lombok.Setter;
import lombok.Getter;
import com.areeb.foodDeliveryApp.auth_users.entites.User;
import com.areeb.foodDeliveryApp.menu.entities.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDateTime createdAt;

    @Column(name = "order_id")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
