package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
			
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	
		@Bean
		public CommandLineRunner demo() {return (args) -> {
			Category aCategory = new Category("Research");
			 categoryRepository.save(aCategory);
			 
			 Category bCategory = new Category("Facts");
			 categoryRepository.save(bCategory);
			 
			 Category cCategory = new Category("Cook books");
			 categoryRepository.save(cCategory);
			
		 Book a = new Book("Katto Kassinen ja sotesotku", "Astrid Lindgren", 1968, "978-3-16-148410-0", 14, bCategory);
		 bookRepository.save(a);
		 Book b = new Book("Katto Kassinen ja kansalla laskutettu aamiainen", "Astrid Lindgren", 1970, "346-9-16-148410-0", 15, cCategory);
		 bookRepository.save(b);
		
		 
		//pass:user, rounds 10
		User user1 = new User("user",
		"$2a$10$VZD8fMtBiE.f1T4viVb.NeSnxKdG9MyrpPRvWHKeyUDSMg.ZU3l3K","user@user.com" ,"USER");
			userRepository.save(user1);
		
		//pass:admin, rounds 10
		User user2 = new User("admin",
		"$2a$10$3pWlcjIGDG1nqbDJlmsmXOBIhbKrGr3DYILkLGfKcLF4UYbi3RuAq","admin@admin.com", "ADMIN");				
			userRepository.save(user2);	 
		};		
		}
}