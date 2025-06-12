package com.karn.adoption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoshlongAiPetDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoshlongAiPetDemoApplication.class, args);
	}

//	@Bean
//	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
//		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//		resourceDatabasePopulator.addScript(new ClassPathResource("/schema.sql"));
//		resourceDatabasePopulator.addScript(new ClassPathResource("/data.sql"));
//		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//		dataSourceInitializer.setDataSource(dataSource);
//		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//		return dataSourceInitializer;
//	}
}
