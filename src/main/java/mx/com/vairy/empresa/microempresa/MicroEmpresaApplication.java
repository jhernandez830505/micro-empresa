package mx.com.vairy.empresa.microempresa;

import springfox.documentation.service.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class MicroEmpresaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroEmpresaApplication.class, args);
    }

    @Bean
    public Docket api(
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.title}") String title,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.description}") String description,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.version}") String version,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.termsOfServiceUrl}") String termsOfServiceUrl,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.contact.name}") String contactName,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.contact.url}") String contactUrl,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.contact.email}") String contactEmail,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.license}") String license,
            @Value("${mx.com.vairy.empresa.swagger.apiInfo.licenseUrl}") String licenseUrl
    ) {

        Contact concact = new Contact(contactName, contactUrl, contactEmail);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(
                        title,
                        description,
                        version,
                        termsOfServiceUrl,
                        concact,
                        license,
                        "",
                        Collections.emptyList()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("mx.com.vairy.empresa.microempresa.controller"))
                .build();
    }
}
