package com.newmind.seobackstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhoukc
 * @Description
 */
@SpringBootApplication
@EnableSwagger2
public class SeoBackstageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeoBackstageWebApplication.class, args);
    }
}
