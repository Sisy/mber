package com.mbersapp.rest.domain;

public class EventCreationRequest {

    private String id;
    private String host;
    private String location;
    private String description;

    public EventCreationRequest() {}

    public String getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
