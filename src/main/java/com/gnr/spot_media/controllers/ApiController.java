package com.gnr.spot_media.controllers;

import com.gnr.spot_media.dto.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        StatusResponse resp = new StatusResponse("OK", Instant.now());
        return ResponseEntity.ok(resp);
    }
}
