package com.casestudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Autowired
//    Environment environment;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String fileUpload = environment.getProperty("file_upload").toString();
//
//        registry.addResourceHandler("/i/**") //
//                .addResourceLocations("file:" + fileUpload);
//    }
}
