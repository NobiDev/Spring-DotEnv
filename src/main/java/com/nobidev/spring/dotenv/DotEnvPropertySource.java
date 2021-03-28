package com.nobidev.spring.dotenv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

public class DotEnvPropertySource extends PropertySource<DotEnvPropertyLoader> {

    public static final String DOTENV_PROPERTY_SOURCE_NAME = "env";
    private static final Log logger = LogFactory.getLog(PropertySource.class);
    private static final String PREFIX = "env.";

    public DotEnvPropertySource(String name) {
        super(name, new DotEnvPropertyLoader());
    }

    public DotEnvPropertySource() {
        this(DOTENV_PROPERTY_SOURCE_NAME);
    }

    public static void addToEnvironment(ConfigurableEnvironment environment) {
        environment
                .getPropertySources()
                .addAfter(
                        StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
                        new com.nobidev.spring.dotenv.DotEnvPropertySource(DOTENV_PROPERTY_SOURCE_NAME));

        logger.trace("DotenvPropertySource add to Environment");
    }

    @Override
    public Object getProperty(String name) {
        if (!name.startsWith(PREFIX)) {
            return null;
        }

        if (logger.isTraceEnabled()) {
            logger.trace("Getting env property for '" + name + "'");
        }

        return getSource().getValue(name.substring(PREFIX.length()));
    }
}