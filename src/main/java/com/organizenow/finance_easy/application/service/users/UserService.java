package com.organizenow.finance_easy.application.service.users;

import com.organizenow.finance_easy.domain.dto.request.UserRegistrationRequestDTO;
import com.organizenow.finance_easy.domain.dto.response.UserRegistrationResponseDTO;
import com.organizenow.finance_easy.domain.entity.User;
import com.organizenow.finance_easy.domain.enums.ActiveType;
import com.organizenow.finance_easy.domain.enums.UserRole;
import com.organizenow.finance_easy.domain.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserRegistrationResponseDTO registerNewUser(UserRegistrationRequestDTO userRegistration) {
        if (userRepository.existsByEmailAddress(userRegistration.getEmailAddress())) {
            throw new RuntimeException("User already exists");
        }

        User user = this.toDomain(userRegistration);
        userRepository.save(user);
        UserRegistrationResponseDTO response = this.toResponse(user);

        return response;
    }

    public User toDomain(UserRegistrationRequestDTO userRequest) {

        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUserName(userRequest.getUserName());
        user.setEmailAddress(userRequest.getEmailAddress());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setDateOfBirth(LocalDate.parse(userRequest.getDateOfBirth()));
        user.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        user.setRole(UserRole.USER);
        user.setIsActive(ActiveType.ACTIVE);

        return user;
    }

    public UserRegistrationResponseDTO toResponse(User user) {

        UserRegistrationResponseDTO newUser = new UserRegistrationResponseDTO();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserName(user.getUserName());
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setDateOfBirth(user.getDateOfBirth().toString());

        return newUser;
    }
}