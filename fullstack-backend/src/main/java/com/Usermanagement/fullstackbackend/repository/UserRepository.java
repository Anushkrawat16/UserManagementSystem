package com.Usermanagement.fullstackbackend.repository;

import com.Usermanagement.fullstackbackend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user ,Long> {

}
