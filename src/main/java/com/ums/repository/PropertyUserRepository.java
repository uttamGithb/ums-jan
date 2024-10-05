package com.ums.repository;

import com.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyUserRepository extends JpaRepository<User, Long> {
}