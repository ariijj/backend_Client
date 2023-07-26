package com.example.HelloWorld;

import com.example.HelloWorld.Entity.Admin;
import com.example.HelloWorld.Repo.AdminRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Hello World Project",
				 version="1.0.0",
				description = "this project is only for learning",
				termsOfService="runcode",
				contact = @Contact(
						name="Mr Rutvik",
						email = "runcodenow@gmail.com"

				),
				license=@License(
						name="licence",
						url="runcodenow"
				)



		)
)
public class HelloWorldApplication {

	public static void main(String[] args) {
		AdminRepo adminRepository = null;
		SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println("hello");
		Admin admin1;
		Admin admin2;
		 admin1=new Admin("rh1@gmail.com","123456789");
	    admin2=new Admin("rh2@gmail.com","123456789");
		adminRepository.save(admin2);
		adminRepository.save(admin2);
	}}

