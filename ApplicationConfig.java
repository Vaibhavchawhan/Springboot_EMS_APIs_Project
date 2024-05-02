package com.qsp.springboot_employee_management_system.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
public class ApplicationConfig {
    
	@Bean                             //   third party enable
	public Docket getDocket() {
		     
		Contact contact= new Contact("Qspider", "qspider.com", "vaibhavchawhan123@gmail.com");
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		ApiInfo  apiInfo=new ApiInfo("EmpManSystem", "To mange Emp","Version1.0", "www.ems.com", contact, "QSP001", "www.qsp001.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_employee_management_system")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
		
}
