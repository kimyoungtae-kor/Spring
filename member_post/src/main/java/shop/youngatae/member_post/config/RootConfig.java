package shop.youngatae.member_post.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class RootConfig {
  // @Bean
  public DataSource dataSource(){
    return new HikariDataSource(hikariConfig());
  }

  public HikariConfig hikariConfig(){
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
    config.setJdbcUrl("jdbc:log4jdbc:mariadb://54.180.100.36:3306/post");
    config.setUsername("sample");
    config.setPassword("1234");
    return config;
  }
}
