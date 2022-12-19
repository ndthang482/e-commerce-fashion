package com.savvycom.authservice;
import com.savvycom.authservice.domain.entity.User;
import com.savvycom.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@EnableDiscoveryClient
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setUsername("corner99vn@gmail.com");
//        user.setName("corner");
//        user.setPassword(passwordEncoder.encode("corner2"));
//        user.setRole("admin");
//        user.setPasswordResetToken("123456");
//        userRepository.save(user);
//    }
}
