package com.example.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
    private UserRepository repository;

    @Test
    public void findByemailShouldReturnUser() {
        User users = repository.findByUsername("user");
        assertThat(users.getUsername()).isEqualTo("user");
    }
    
    @Test
    public void createNewUser() {
    	//User(String username, String passwordHash, String email, String role)
    	User user = new User("appuser", "$2a$10$VZD8fMtBiE.f1T4viVb.NeSnxKdG9MyrpPRvWHKeyUDSMg.ZU3l3K",
    			"user@user.fi", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    
    
    public void deleteUser() {
    	 User user = repository.findByUsername("user");
		repository.delete(user);
		
		 User newUser = repository.findByUsername("user");
		assertThat(newUser).isEqualTo("null");
     }

}