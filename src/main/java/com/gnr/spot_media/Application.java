package com.gnr.spot_media;

import com.gnr.spot_media.entities.Location;
import com.gnr.spot_media.entities.Product;
import com.gnr.spot_media.repositories.LocationRepository;
import com.gnr.spot_media.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication


public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}

}
