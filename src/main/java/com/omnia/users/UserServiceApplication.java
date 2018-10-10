package com.omnia.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    @Autowired
    private Environment env;

    @Bean
    @RefreshScope
    public DataSource dataSourceLocal() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (env.getProperty("useDB").equalsIgnoreCase("local")) {
            dataSource.setDriverClassName(env.getProperty("localDBDriver"));
            dataSource.setUrl(env.getProperty("localDBUrl"));
            dataSource.setUsername(env.getProperty("localDBUser"));
            dataSource.setPassword(env.getProperty("localDBPass"));
        } else if (env.getProperty("useDB").equalsIgnoreCase("dev")) {
            dataSource.setDriverClassName(env.getProperty("devDBDriver"));
            dataSource.setUrl(env.getProperty("devDBUrl"));
            dataSource.setUsername(env.getProperty("devDBUser"));
            dataSource.setPassword(env.getProperty("devDBPass"));
        }

        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

