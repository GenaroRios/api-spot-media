package com.gnr.spot_media.repositories;

import com.gnr.spot_media.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByAvailableTrue();
    List<Product> findByAvailableTrueAndLocations_Id(Long locationId);
    List<Product> findByAvailableTrueAndLocations_Name(String locationName);
}
