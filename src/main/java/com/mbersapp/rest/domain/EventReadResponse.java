package com.mbersapp.rest.domain;

import java.util.Date;

public class EventReadResponse {

    private String id;
    private String host;
    private String location;
    private String description;

    public EventReadResponse() {}

    public EventReadResponse(String id, String host, String location, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventReadResponse that = (EventReadResponse) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public static Builder eventReadResponseBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String host;
        private String location;
        private String description;
        private Date createdAt;

        public EventReadResponse build() {
            return new EventReadResponse(id, host, location, description);
        }

        public Builder clone(EventReadResponse eventEntity) {
            id = eventEntity.id;
            host = eventEntity.host;
            location = eventEntity.location;
            description = eventEntity.description;

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
