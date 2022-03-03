package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;
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
		 
		 
		};		
		}
}