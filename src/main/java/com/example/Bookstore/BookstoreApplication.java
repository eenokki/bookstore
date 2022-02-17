package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
			
		@Bean
		public CommandLineRunner demo(BookRepository repository) {return (args) -> {
		 Book a = new Book("Katto Kassinen ja sotesotku", "Astrid Lindgren", 1968, "978-3-16-148410-0", 14);
		 repository.save(a);
		 Book b = new Book("Katto Kassinen ja kansalla laskutettu aamiainen", "Astrid Lindgren", 1970, "346-9-16-148410-0", 15);
		 repository.save(b);
		};		
		}
}