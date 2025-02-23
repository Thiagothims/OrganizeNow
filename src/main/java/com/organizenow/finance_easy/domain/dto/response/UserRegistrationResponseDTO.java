package com.organizenow.finance_easy.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponseDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private String dateOfBirth;
}