package com.foodieapp.adminService.service;

import com.foodieapp.adminService.domain.Admin;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> generateToken(Admin admin);
}
