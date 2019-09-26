package com.unusual.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Igor on 9/25/2019.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.unusual.model","com.unusual.utils"})
@EnableJpaRepositories(basePackages = {"com.unusual.repository"})
@EnableTransactionManagement
public class RepositoryConfig {
}
