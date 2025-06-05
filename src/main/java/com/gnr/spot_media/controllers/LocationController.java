package com.gnr.spot_media.controllers;

import com.gnr.spot_media.dto.LocationDTO;
import com.gnr.spot_media.dto.LocationSimpleDTO;
import com.gnr.spot_media.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    //Gets de ubicaciones que devuelvan Array de <Ubicacion, id> sin la lista de servicios

    @GetMapping("")
    public List<LocationSimpleDTO> getLocationsName(){
        return locationService.getLocationsName();
    }

    @GetMapping("/full")
    public List<LocationDTO> getLocations()
    {
        return locationService.getLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "isMobile") Boolean isMobile) {
        Optional<LocationDTO> locationDTO = locationService.getLocationById(id, isMobile);

        return locationDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
