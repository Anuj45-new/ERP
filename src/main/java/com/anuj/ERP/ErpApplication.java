package com.anuj.ERP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpApplication.class, args);
	}

}

//According to REST conventions:
//GET → Fetch data → Use URL parameters (@RequestParam, @PathVariable)
//POST → Create data → Use @RequestBody
//PATCH/PUT → Update data → Use @RequestBody
//DELETE → Usually use @PathVariable or sometimes @RequestParam