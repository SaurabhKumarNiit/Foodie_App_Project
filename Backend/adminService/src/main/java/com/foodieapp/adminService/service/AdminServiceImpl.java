package com.foodieapp.adminService.service;

import com.foodieapp.adminService.domain.Admin;
import com.foodieapp.adminService.exception.AdminNotFoundException;
import com.foodieapp.adminService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) throws AdminNotFoundException {
        Admin admin = adminRepository.findByEmailAndPassword(email, password);
        if (admin == null){
            throw new AdminNotFoundException();
        }
        return admin;
    }
}
