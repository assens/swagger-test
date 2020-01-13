package com.foo.test.swagger.config;

import java.util.Collections;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket clientRest(final BuildProperties buildProperties) {
    final ApiInfo appInfo = new ApiInfoBuilder()
        .title(buildProperties.getArtifact())
        .version(buildProperties.getVersion())
        .build();
    return new Docket(DocumentationType.SWAGGER_2)
        .securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")))
        .select()
        .paths(PathSelectors.regex("/cust.*"))
        .build()
        .apiInfo(appInfo)
        .useDefaultResponseMessages(false);
  }
}
