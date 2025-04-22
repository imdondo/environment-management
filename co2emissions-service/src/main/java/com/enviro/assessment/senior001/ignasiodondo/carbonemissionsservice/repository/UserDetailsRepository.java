package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.repository;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
}
