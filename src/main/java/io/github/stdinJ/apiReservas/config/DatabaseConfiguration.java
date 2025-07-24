package io.github.stdinJ.apiReservas.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;


    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url); // não se esqueça dessa linha!
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(10);
        config.setPoolName("gerenciamento_db");
        config.setMaxLifetime(600000);
        config.setConnectionTimeout(100000);
        config.setConnectionTestQuery("select 1");

        return new HikariDataSource(config);
    }

}
