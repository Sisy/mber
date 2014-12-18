package com.mbersapp.rest.domain;

public class EventCreationResponse {

    private String id;
    private String host;
    private String location;
    private String description;

    public EventCreationResponse() {}

    public EventCreationResponse(String id, String host, String location, String description) {
        this.id = id;
        this.host = host;
        this.location = location;
        this.description = description;
    }

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

    public static Builder eventCreationResponseBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String host;
        private String location;
        private String description;

        public EventCreationResponse build() {
            return new EventCreationResponse(id, host, location, description);
        }

        public Builder clone(EventCreationResponse eventCreationResponse) {
            id = eventCreationResponse.id;
            host = eventCreationResponse.host;
            location = eventCreationResponse.location;
            description = eventCreationResponse.description;

            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
    }
}
