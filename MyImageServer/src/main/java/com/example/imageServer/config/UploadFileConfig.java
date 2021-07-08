package com.example.imageServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class UploadFileConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/images/**").addResourceLocations("file:/F:/blog-images/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/www/myProject/images/");
        super.addResourceHandlers(registry);

    }

}
