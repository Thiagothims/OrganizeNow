package com.organizenow.finance_easy.infrastructure.persistence;

import com.organizenow.finance_easy.domain.entity.User;
import com.organizenow.finance_easy.domain.repository.users.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUsersRepository extends JpaRepository<User, UUID>, UserRepository {
}
