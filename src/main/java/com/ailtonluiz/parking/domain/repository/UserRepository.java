package com.ailtonluiz.parking.domain.repository;

import com.ailtonluiz.parking.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
