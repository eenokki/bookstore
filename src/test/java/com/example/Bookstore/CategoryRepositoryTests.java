package com.example.Bookstore;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	@Autowired
    private CategoryRepository repository;

    @Test
    public void findBycategoryNameShouldReturnCategory() {
        List<Category> categories = repository.findBycategoryName("Facts");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryName()).isEqualTo("Facts");
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Fake news");
    	repository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }    
    @Test

    public void deleteCategory() {
		List<Category> categories = repository.findBycategoryName("Facts");
		Category category = categories.get(0);
		repository.delete(category);
		
		List<Category> newCategory = repository.findBycategoryName("Facts");
		assertThat(newCategory).hasSize(0);
     }


}
