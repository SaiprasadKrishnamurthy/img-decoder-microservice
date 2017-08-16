package com.sai.imgscanner;

import com.google.common.base.Predicates;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by achat1 on 9/22/15.
 */
@Configuration
@PropertySource("classpath:application.properties")
@Data
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @Bean
    public Docket resolverApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("image-scanner-microservice")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error"))) // Exclude Spring error controllers
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Image Scanner REST API")
                .description("REST API to scan and recogonize various images such as QR codes, Bar codes and Device Plates.")
                .version("1.0-SNAPSHOT")
                .build();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}