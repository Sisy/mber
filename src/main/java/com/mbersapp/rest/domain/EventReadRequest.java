package com.mbersapp.rest.domain;

public class EventReadRequest {

    private String id;

    private EventReadRequest() {}

    private EventReadRequest(Builder builder) {
        id = builder.id;
    }

    public String getId() {
        return id;
    }

    public static Builder eventReadRequestBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EventReadRequest{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventReadRequest that = (EventReadRequest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public EventReadRequest build() {
            return new EventReadRequest(this);
        }
    }
}
