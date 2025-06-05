package com.gnr.spot_media.service;

import com.gnr.spot_media.dto.LocationDTO;
import com.gnr.spot_media.dto.LocationSimpleDTO;
import com.gnr.spot_media.mappers.LocationMapper;
import com.gnr.spot_media.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDTO> getLocations()
    {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper)
                .toList();
    }

    public List<LocationSimpleDTO> getLocationsName(){
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::toSimpleDTO)
                .toList();
    }

    public Optional<LocationDTO> getLocationById(Long id, Boolean isMobile){
        return locationRepository.findById(id)
                .map(location -> locationMapper.apply(location, isMobile));
    }
}
