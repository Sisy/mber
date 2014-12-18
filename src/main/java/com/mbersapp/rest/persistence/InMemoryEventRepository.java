package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryEventRepository implements EventRepository {

    private Map<String, EventEntity> events = new HashMap<>();

    @Override
    public EventEntity create(EventEntity event) {
        events.put(event.getId(), event);

        return event;
    }

    @Override
    public List<EventEntity> readlAll() {
        return new ArrayList<>(events.values());
    }

    @Override
    public EventEntity read(String id) {
        return events.get(id);
    }
}
