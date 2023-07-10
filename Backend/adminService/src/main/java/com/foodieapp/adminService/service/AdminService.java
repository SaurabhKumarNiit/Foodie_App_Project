package com.foodieapp.adminService.service;

import com.foodieapp.adminService.domain.Admin;
import com.foodieapp.adminService.exception.AdminNotFoundException;

public interface AdminService {
    public Admin addAdmin(Admin admin);

    public Admin findByEmailAndPassword(String email,String password) throws AdminNotFoundException;

}
