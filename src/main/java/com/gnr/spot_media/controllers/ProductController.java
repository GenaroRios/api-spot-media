package com.gnr.spot_media.controllers;

import com.gnr.spot_media.dto.ProductDTO;
import com.gnr.spot_media.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDTO> getAll()
    {
        return productService.getProducts();
    }

    @GetMapping("/available-by-location")
    public ResponseEntity<List<ProductDTO>> getAvailableProductsByLocation(
            @RequestParam(required = false, name = "locationId") Long locationId,
            @RequestParam(required = false, name = "locationName") String locationName,
            @RequestParam(name = "isMobile") boolean isMobile) {

        List<ProductDTO> products;

        if (locationId != null) {
            products = productService.getProductsByLocationId(locationId, isMobile);
        } else if (locationName != null) {
            products = productService.getProductsByLocationName(locationName);
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(Collections.emptyList());
        }

        return ResponseEntity.ok(products);
    }
}
