package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{ 
	User findByUsername(String username);

	/*List<User> findByEmail(String string);
	List<User> findByUsernamelist(String string);*/
		
}
