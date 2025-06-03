package com.gnr.spot_media.mappers;

import com.gnr.spot_media.dto.ProductDTO;
import com.gnr.spot_media.entities.Product;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product key) {
        return new ProductDTO(
                key.getId(),
                key.getTitle(),
                key.getDescription(),
                key.getImage(),
                key.getShortTitle(),
                key.getThumbnail()
        );
    }

    public ProductDTO apply(Product key, boolean isMobile){
        return new ProductDTO(
                key.getId(),
                key.getTitle(),
                key.getDescription(),
                key.getImageUrl(isMobile),
                key.getShortTitle(),
                key.getThumbnail()
        );
    }
}
