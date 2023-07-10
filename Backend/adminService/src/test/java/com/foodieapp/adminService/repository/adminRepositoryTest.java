//package com.foodieapp.adminService.repository;
//
//
//import com.foodieapp.adminService.domain.Admin;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class adminRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    private Admin admin;
//
//
//    @BeforeEach
//    public void setUp(){
//        admin = new Admin("admin@gmail.com","admin");
//    }
//
//    @AfterEach
//    public void tearDown() {
//        admin = null;
//    }
//
//    @Test
//    public void adminTest(){
//        Admin admin1 = adminRepository.save(admin);
//
//        Admin admin2 = entityManager.find(Admin.class,admin1.getEmail());
//
//        assertThat(admin.getEmail()).isEqualTo(admin2.getEmail());
//    }
//}
