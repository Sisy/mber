package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;

import java.util.List;

public interface EventRepository {

    EventEntity create(EventEntity event);

    List<EventEntity> readlAll();

    EventEntity read(String id);
}
