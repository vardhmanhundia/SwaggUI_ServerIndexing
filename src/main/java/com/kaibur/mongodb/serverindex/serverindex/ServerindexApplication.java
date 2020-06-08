package com.kaibur.mongodb.serverindex.serverindex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ServerindexApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerindexApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/server/*"))
                .apis(RequestHandlerSelectors.basePackage("com.kaibur"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "server Indexing API",
                "Spring-Boot Mongodb API",
                "2.0",
                "Free to use",
                new springfox.documentation.service.Contact("Vardhman Hundia","https://vardhmanhundia.github.io/profileWebsite/", "vardhmanhundia@gmail.com"),
                "API License",
                "http://javabrains.io",
                Collections.emptyList());
    }

}
