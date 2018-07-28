package com.michael.sofa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:rpc-sofa-boot-starter-samples.xml"})
public class Application {

	public static void main(String[] args) throws Exception { 
		SpringApplication.run(Application.class, args);
	}
	
}
