package com.example.TravelAgencyServer;

import com.example.TravelAgencyServer.service.DataInitializationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelAgencyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyServerApplication.class, args);
	}

    /*@Bean
    public CommandLineRunner initData(DataInitializationService initService) {
        return args -> {
            initService.initializeToursData();
            System.out.println("Тестовые данные успешно созданы!");
        };
    }*/

}
