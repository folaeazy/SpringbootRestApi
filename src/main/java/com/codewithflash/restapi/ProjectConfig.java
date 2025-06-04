package com.codewithflash.restapi;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
// BEAN CONFIGURATION FOR CUSTOM DB  DATASOURCE CONNECTION
@Configuration
public class ProjectConfig {

//    @Value("${custom.datasource.url}")
//    private  String dataSourceUrl;
//
//    @Value("${custom.datasource.username}")
//    private  String dataSourceUsername;
//
//    @Value("${custom.datasource.password}")
//    private String dataSourcePassword;
//
//
//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl(dataSourceUrl);
//        dataSource.setUsername(dataSourceUsername);
//        dataSource.setPassword(dataSourcePassword);
//        dataSource.setConnectionTimeout(1000);
//        return  dataSource;
//    }
}
