package tw.lab.spring2.config;

import java.beans.BeanProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	@Value("${lab.company.name}")
	private String companyName;
	
	@Bean
	public String companyName() {
		return companyName;
	}
}