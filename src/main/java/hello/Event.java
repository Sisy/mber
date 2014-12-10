package hello;

public class Event {

    private String id;
    private String host;
    private String location;
    private String description;

    public Event() {}

    public Event(String id, String host, String location, String description) {
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
    public Object clone() {
        return new Event(id, host, location, description);
    }

    public static Builder eventBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String host;
        private String location;
        private String description;

        public Event build() {
            return new Event(id, host, location, description);
        }

        public Builder clone(Event event) {
            Event clone = (Event) event.clone();
            id = clone.id;
            host = clone.host;
            location = clone.location;
            description = clone.description;

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