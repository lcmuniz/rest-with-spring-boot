package com.lcmuniz.rest_with_spring_boot.integration.v2;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ApplicationContextFailureProcessor;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startable;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbtsractIntegrationTest.Initializer.class )
public class AbtsractIntegrationTest {

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        private final static PostgreSQLContainer<?> postgresql = new PostgreSQLContainer<>("postgres:17");

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            startContainers();
            ConfigurableEnvironment env = applicationContext.getEnvironment();
            MapPropertySource props = new MapPropertySource("testcontainers", createConnectionConfiguration());
            env.getPropertySources().addFirst(props);
        }

        private static Map<String, Object> createConnectionConfiguration() {
            return Map.of(
                    "spring.datasource.url", postgresql.getJdbcUrl(),
                    "spring.datasource.username", postgresql.getUsername(),
                    "spring.datasource.password", postgresql.getPassword());
        }

        private static void startContainers() {
            Startables.deepStart(Stream.of(postgresql)).join();
        }
    }

}
