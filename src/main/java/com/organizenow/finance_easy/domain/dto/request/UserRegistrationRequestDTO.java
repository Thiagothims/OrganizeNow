package com.organizenow.finance_easy.domain.dto.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDTO {
    @NonNull
    private String firstName;
    private String lastName;
    @NonNull
    private String userName;
    @NonNull
    @Email
    private String emailAddress;
    @NonNull
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
}