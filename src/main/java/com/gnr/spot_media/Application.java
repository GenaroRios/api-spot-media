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
		ApplicationContext context = SpringApplication.run(Application.class, args);

		LocationRepository locationRepo = context.getBean(LocationRepository.class);
		ProductRepository ProductRepo = context.getBean(ProductRepository.class);

		Location playaGrande = new Location("Playa Grande", new ArrayList<>());
		Location playaVarese = new Location("Playa Varese", new ArrayList<>());
		Location playaPerla = new Location("Playas La Perla", new ArrayList<>());
		Location playaSur = new Location("Playas Del Sur", new ArrayList<>());

		locationRepo.saveAll(List.of(playaGrande, playaVarese, playaPerla, playaSur));

		List<Product> Products = List.of(
				new Product(
						"Tótem Digital",
						"5 Tótems Digitales de última generación<br>" +
								"Ubicados en los principales accesos peatonales al Complejo<br>" +
								"Altura 2,80 Metros<br>" +
								"Monitor Led de 65” de alta definición<br>" +
								"Encendido de 07:00 a 03:00 Horas<br>" +
								"Máximo 10 anunciantes por dispositivo",
						"https://res.cloudinary.com/diixwwqeu/image/upload/v1746188726/totem-digital_eo4hvp.avif",
						"mobile_url",
						"DIGITALES",
						"https://res.cloudinary.com/diixwwqeu/image/upload/v1745936599/digitales_yj8ial.avif",
						List.of(playaGrande, playaVarese)
				));

		ProductRepo.saveAll(Products);
	}

}
