package org.gaborbalazs.smartplatform.edgeservice.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("!prod & !integration-test")
@Configuration
class SwaggerConfiguration {

    @Value("${swagger.title:#{null}}")
    private String title;

    @Value("${swagger.description:#{null}}")
    private String description;

    @Value("${swagger.version:#{null}}")
    private String version;

    @Value("${swagger.terms-of-service-url:#{null}}")
    private String termsOfServiceUrl;

    @Value("${swagger.contact-name:#{null}}")
    private String contactName;

    @Value("${swagger.contact-url:#{null}}")
    private String contactUrl;

    @Value("${swagger.contact-email:#{null}}")
    private String contactEmail;

    @Value("${swagger.license:#{null}}")
    private String license;

    @Value("${swagger.license-url:#{null}}")
    private String licenseUrl;


    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .termsOfService(termsOfServiceUrl)
                        .contact(new Contact()
                                .name(contactName)
                                .url(contactUrl)
                                .email(contactEmail))
                        .license(new License()
                                .name(license)
                                .url(licenseUrl)));
    }
}
