package com.michael.sofa.reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

import com.michael.sofa.service.IHelloService;

@ImportResource({ "classpath:rpc-sofa-boot-starter-sample.xml" })
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) throws Exception {
		 SpringApplication springApplication = new SpringApplication(Application.class);
		    ApplicationContext applicationContext = springApplication.run(args);

		    IHelloService helloService = (IHelloService) applicationContext
		        .getBean("helloService");

		    System.out.println(helloService.sayHello("Michael"));
	}
	
}
