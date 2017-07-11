package com.example.demo.util;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created zft on 2017/7/11.
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger.ui", value = "enable", matchIfMissing = true)
@PropertySource(value = "classpath:/config/swagger.properties", ignoreResourceNotFound = true)
public class SwaggerAutoConfiguration {

    @Value("${group}")
    private String group;
    @Value("${title}")
    private String title;
    @Value("${description}")
    private String description;
    @Value("${version}")
    private String version;
    @Value("${name}")
    private String name;
    @Value("${email}")
    private String email;
    @Value("${url}")
    private String url;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(group)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(name, url, email))
                .version(version)
                .build();
    }
}
