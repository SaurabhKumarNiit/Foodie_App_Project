package com.foodieapp.adminService.controller;

import com.foodieapp.adminService.domain.Admin;
import com.foodieapp.adminService.exception.AdminNotFoundException;
import com.foodieapp.adminService.service.AdminServiceImpl;
import com.foodieapp.adminService.service.SecurityTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
    private AdminServiceImpl adminServiceImpl;

    private SecurityTokenGenerator securityTokenGenerator;

    public AdminController(AdminServiceImpl adminServiceImpl, SecurityTokenGenerator securityTokenGenerator) {
        this.adminServiceImpl = adminServiceImpl;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    //  http://localhost:8085/admin/register
    @PostMapping("/register")
    public ResponseEntity<?> saveAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminServiceImpl.addAdmin(admin), HttpStatus.CREATED);
    }

    //  http://localhost:8085/admin/login
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
        ResponseEntity responseEntity = null;
        Map<String,String> map = null;
        try {
            Admin admin1 = adminServiceImpl.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
            if (admin1.getEmail().equals("admin@gmail.com"))
            {
                return new ResponseEntity<>(securityTokenGenerator.generateToken(admin),HttpStatus.OK);
                //map = securityTokenGenerator.generateToken(admin);
            }
            //responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
        }catch (AdminNotFoundException e) {
            throw new AdminNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>("Try After Some Time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
