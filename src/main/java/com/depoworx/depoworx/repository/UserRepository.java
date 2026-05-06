package com.depoworx.depoworx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depoworx.depoworx.Domain.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
    boolean existsByEmail(String email);
    

}
