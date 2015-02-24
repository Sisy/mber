package com.mbersapp.rest.domain;

public class EventCreationResponse {

    private String id;
    private String host;
    private String location;
    private String description;

    private EventCreationResponse() {}

    private EventCreationResponse(Builder builder) {
        id = builder.id;
        host = builder.host;
        location = builder.location;
        description = builder.description;
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

    @Override
    public String toString() {
        return "EventCreationResponse{" +
                "id='" + id + '\'' +
                ", host='" + host + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventCreationResponse that = (EventCreationResponse) o;

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

    public static final class Builder {
        private String id;
        private String host;
        private String location;
        private String description;

        private Builder() {
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

        public EventCreationResponse build() {
            return new EventCreationResponse(this);
        }
    }
}
