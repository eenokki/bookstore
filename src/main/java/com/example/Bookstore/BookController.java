package com.example.Bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BookController {
	@RequestMapping("/index")
	public String identifier(@RequestParam(name="title") String title) {
		return title;
		}	

}
