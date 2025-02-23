package com.organizenow.finance_easy.domain.repository.users;

import com.organizenow.finance_easy.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID oid);
    Optional<User> findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
}
