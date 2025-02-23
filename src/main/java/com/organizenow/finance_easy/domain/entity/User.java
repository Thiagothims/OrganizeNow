package com.organizenow.finance_easy.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.organizenow.finance_easy.domain.enums.ActiveType;
import com.organizenow.finance_easy.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALLUSERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID oid;

    @Version
    private Long version;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true)
    private String emailAddress;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "IS_ACTIVE", nullable = false)
    private ActiveType isActive;

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private OffsetDateTime updatedAt;

    @Column(name = "DELETED_AT")
    private OffsetDateTime deletedAt;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;
}