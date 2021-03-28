package com.nobidev.spring.dotenv;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("SpringFacetCodeInspection")
@Configuration()
public class DotEnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        DotEnvPropertySource.addToEnvironment(applicationContext.getEnvironment());
    }
}
