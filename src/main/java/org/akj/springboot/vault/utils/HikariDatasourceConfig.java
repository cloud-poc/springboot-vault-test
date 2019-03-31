package org.akj.springboot.vault.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class HikariDatasourceConfig extends HikariConfig {
	
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String pwd;

	@Bean
	@Primary
	public DataSource dataSource() throws SQLException {
		
		// use the credential configured in Vault to replace the spring config
		this.setUsername(this.userName);
		this.setPassword(this.pwd);
		
		return new HikariDataSource(this);
	}

}