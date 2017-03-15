package edu.project.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Marango on 07/03/2017.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("edu.project")
public class JpaIntegrationConfig {
}
