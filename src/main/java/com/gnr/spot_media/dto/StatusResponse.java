package com.gnr.spot_media.dto;

import java.time.Instant;

public class StatusResponse {
    private String status;
    private Instant timestamp;

    public StatusResponse(String status, Instant timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters y setters
    public String getStatus() {
        return status;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
}
