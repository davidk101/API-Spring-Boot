package com.example.api.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDatasource {

    // Hikari is the recommended data source for Spring Boot
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource(){ // instantiate datasource as a bean

        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
