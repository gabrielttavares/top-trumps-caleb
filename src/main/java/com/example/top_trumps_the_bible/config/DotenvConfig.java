package com.example.top_trumps_the_bible.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Profile("!prod")
public class DotenvConfig {

    public static final Logger logger = LoggerFactory.getLogger(DotenvConfig.class);

    @PostConstruct
    public void init() {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .directory(".")
                    .ignoreIfMissing()
                    .load();

            dotenv.entries().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();

                logger.debug("Loading environment variable: {}", key);

                System.setProperty(key, value);
            });

            logger.info("Environment variables loaded successfully from .env file");
        } catch (Exception e) {
            logger.error("Error loading .env file: {}", e.getMessage());
        }
    }
}
