package com.mbersapp.rest.domain;

public class EventReadRequest {

    private String id;

    public EventReadRequest() {}

    public EventReadRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public static Builder eventReadRequestBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String id;

        public EventReadRequest build() {
            return new EventReadRequest(id);
        }

        public Builder clone(EventReadRequest eventReadRequest) {
            id = eventReadRequest.id;

            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }
    }
}
