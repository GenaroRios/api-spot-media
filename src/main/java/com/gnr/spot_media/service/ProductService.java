package com.gnr.spot_media.service;

import com.gnr.spot_media.dto.ProductDTO;
import com.gnr.spot_media.mappers.ProductMapper;
import com.gnr.spot_media.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getProducts()
    {
        return productRepository.findByAvailableTrue()
                .stream()
                .map(productMapper)
                .toList();
    }

    public Optional<ProductDTO> getById(Long id){
        return productRepository.findById(id)
                .map(productMapper);
    }

    public List<ProductDTO> getProductsByLocationId(Long id, boolean isMobile)
    {
        return productRepository.findByAvailableTrueAndLocations_Id(id)
                .stream()
                .map(product -> productMapper.apply(product, isMobile))
                .toList();
    }

    public List<ProductDTO> getProductsByLocationName(String locationName)
    {
        return productRepository.findByAvailableTrueAndLocations_Name(locationName)
                .stream()
                .map(productMapper)
                .toList();
    }

}
