package com.nobidev.spring.dotenv;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class DotEnv {
    public static void initialize(SpringApplicationBuilder builder) {
        builder.initializers(new DotEnvInitializer());
    }
}
