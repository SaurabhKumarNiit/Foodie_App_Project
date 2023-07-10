package com.foodieapp.adminService.repository;

import com.foodieapp.adminService.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
    public Admin findByEmailAndPassword(String email,String password);
}
