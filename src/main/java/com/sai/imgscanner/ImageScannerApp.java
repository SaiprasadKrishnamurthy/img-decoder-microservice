package com.sai.imgscanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan("com.sai")
@EnableSwagger2
public class ImageScannerApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ImageScannerApp.class, args);
    }
}