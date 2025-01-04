package com.shopme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class MainController {
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

}
