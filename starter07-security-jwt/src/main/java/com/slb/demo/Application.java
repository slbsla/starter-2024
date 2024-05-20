package com.slb.demo;

import com.slb.demo.config.RsaKeyConfigProperties;
import com.slb.demo.model.User;
import com.slb.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner initializeUser(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			User user = new User();
			user.setUsername("exampleuser");
			user.setEmail("example@gmail.com");
			user.setPassword(passwordEncoder.encode("examplepassword"));
			// Save the user to the database
			userRepository.save(user);
		};
	}
}
