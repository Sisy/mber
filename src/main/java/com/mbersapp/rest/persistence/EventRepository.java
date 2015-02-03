package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;

import java.util.List;

public interface EventRepository {

    EventEntity create(EventEntity event);

    List<EventEntity> readAll();

    EventEntity read(String id);
}
