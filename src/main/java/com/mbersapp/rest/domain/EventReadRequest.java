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
