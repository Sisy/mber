package com.mbersapp.rest.model;

import java.util.Date;

public class EventEntity {

    private String id;
    private String host;
    private String location;
    private String description;
    private Date createdAt;

    public EventEntity() {}

    public EventEntity(String id, String host, String location, String description, Date createdAt) {
        this.id = id;
        this.host = host;
        this.location = location;
        this.description = description;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public static Builder eventBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String host;
        private String location;
        private String description;
        private Date createdAt;

        public EventEntity build() {
            return new EventEntity(id, host, location, description, createdAt);
        }

        public Builder clone(EventEntity eventEntity) {
            id = eventEntity.id;
            host = eventEntity.host;
            location = eventEntity.location;
            description = eventEntity.description;
            createdAt = eventEntity.createdAt;

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

        public Builder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }
    }
}