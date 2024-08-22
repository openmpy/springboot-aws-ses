package com.openmpy.mail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class MySQLConfig {

    @Value("${spring.datasource.url")
    private String url;

    @Value("${spring.datasource.username")
    private String username;

    @Value("${spring.datasource.password")
    private String password;

    @Value("${spring.datasource.driver-class-name")
    private String driverClassName;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "createAccountTransactionManager")
    public PlatformTransactionManager createAccountTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
