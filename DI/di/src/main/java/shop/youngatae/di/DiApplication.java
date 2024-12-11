package shop.youngatae.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@SpringBootApplication

//bean 대상 추적
// @Component
// @Service
// @Controller
// @ComponentScan(basePackages = "shop.younatae.di")
public class DiApplication {

	// @Bean
	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

}
