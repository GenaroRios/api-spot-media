package com.gnr.spot_media.dto;

import java.util.List;

public record LocationDTO (

        Long id,
        String name,
        List<ProductDTO> products

){
}
