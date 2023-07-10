package com.foodieapp.adminService.service;

import com.foodieapp.adminService.domain.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Admin admin) {
        String jwtToken = null;
        jwtToken = Jwts.builder()
                .setSubject(admin.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","Admin Successfully Log in");

        return map;
    }
}
