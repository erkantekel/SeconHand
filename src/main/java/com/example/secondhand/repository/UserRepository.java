package com.example.secondhand.repository;

import com.example.secondhand.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
