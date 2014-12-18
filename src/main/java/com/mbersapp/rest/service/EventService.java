package com.mbersapp.rest.service;

import com.mbersapp.rest.domain.EventCreationRequest;
import com.mbersapp.rest.domain.EventCreationResponse;
import com.mbersapp.rest.domain.EventReadRequest;
import com.mbersapp.rest.domain.EventReadResponse;
import com.mbersapp.rest.model.EventEntity;
import com.mbersapp.rest.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.mbersapp.rest.domain.EventCreationResponse.eventCreationResponseBuilder;
import static com.mbersapp.rest.domain.EventReadResponse.eventReadResponseBuilder;
import static com.mbersapp.rest.model.EventEntity.eventBuilder;

@Service
public class EventService {

    private final EventRepository eventRepo;

    @Autowired
    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    public EventCreationResponse createEvent(EventCreationRequest eventCreationRequest) {
        EventEntity eventToCreate = eventBuilder()
                .id(eventCreationRequest.getId())
                .host(eventCreationRequest.getHost())
                .location(eventCreationRequest.getLocation())
                .description(eventCreationRequest.getDescription())
                .createdAt(new Date())
                .build();

        EventEntity createdEvent = eventRepo.create(eventToCreate);

        return eventCreationResponseBuilder()
                .id(createdEvent.getId())
                .host(createdEvent.getHost())
                .location(createdEvent.getLocation())
                .description(createdEvent.getDescription())
                .build();
    }

    public EventReadResponse readEvent(EventReadRequest eventReadRequest) {
        EventEntity event = eventRepo.read(eventReadRequest.getId());

        return eventReadResponseBuilder()
                .id(event.getId())
                .host(event.getHost())
                .location(event.getLocation())
                .description(event.getDescription())
                .build();
    }
}
