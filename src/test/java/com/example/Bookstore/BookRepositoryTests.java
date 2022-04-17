package com.example.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTests {
	
	@Autowired
    private BookRepository repository;

    @Test
    @Order(2)
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Katto Kassinen ja sotesotku");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Astrid Lindgren");
    }
    
    @Test
    @Order(1)
    public void createNewBook() {
    	//Book(String title, String author, int year, String isbn, double price, Category category)
    	Book book = new Book("Kirjanen", "Kirjoittaja", 2222, "1231f", 15, new Category("Daily cat facts"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    @Test
    @Order(3)
    public void deleteBook() {
		List<Book> books = repository.findByTitle("Katto Kassinen ja sotesotku");
		Book book = books.get(0);
		repository.delete(book);
		
		List<Book> newBook = repository.findByTitle("Katto Kassinen ja sotesotku");
		assertThat(newBook).hasSize(0);
     }

}

