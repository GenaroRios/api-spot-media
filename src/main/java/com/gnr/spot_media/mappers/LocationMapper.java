package com.gnr.spot_media.mappers;

import com.gnr.spot_media.dto.LocationDTO;
import com.gnr.spot_media.dto.LocationSimpleDTO;
import com.gnr.spot_media.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper implements Function<Location, LocationDTO> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public LocationDTO apply(Location key) {
        return new LocationDTO(
                key.getId(),
                key.getName(),
                key.getProducts()
                        .stream()
                        .map(productMapper)
                        .toList()
        );
    }

    public LocationSimpleDTO toSimpleDTO(Location key) {
        return new LocationSimpleDTO(
                key.getId(),
                key.getName()
        );
    }
}
