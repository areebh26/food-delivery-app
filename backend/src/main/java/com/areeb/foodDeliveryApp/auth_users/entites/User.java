package com.areeb.foodDeliveryApp.auth_users.entites;

import lombok.Setter;
import lombok.Getter;
import com.areeb.foodDeliveryApp.Order.entities.Order;
import com.areeb.foodDeliveryApp.cart.entities.Cart;
import com.areeb.foodDeliveryApp.payment.entities.Payment;
import com.areeb.foodDeliveryApp.reviews.entities.Review;
import com.areeb.foodDeliveryApp.role.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Default;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
   @Column(nullable = false)
    private String name;

    @Column(unique = true)
    @Email(message = "Invalid Email Format")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String phoneNumber;


    private String profileUrl;
    @Column(nullable = false)
    private String address;

    private boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;




}