package com.mbersapp.rest.service;

import com.mbersapp.rest.domain.EventCreationRequest;
import com.mbersapp.rest.domain.EventCreationResponse;
import com.mbersapp.rest.domain.EventReadRequest;
import com.mbersapp.rest.domain.EventReadResponse;
import com.mbersapp.rest.model.EventEntity;
import com.mbersapp.rest.persistence.SpringEventRepository;
import com.mbersapp.rest.utils.TimeSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mbersapp.rest.domain.EventCreationResponse.eventCreationResponseBuilder;
import static com.mbersapp.rest.domain.EventReadResponse.eventReadResponseBuilder;
import static com.mbersapp.rest.model.EventEntity.eventBuilder;

@Service
public class EventService {

    private final SpringEventRepository eventRepo;
    private final TimeSource timeSource;

    @Autowired
    public EventService(SpringEventRepository eventRepo, TimeSource timeSource) {
        this.eventRepo = eventRepo;
        this.timeSource = timeSource;
    }

    public EventCreationResponse createEvent(EventCreationRequest eventCreationRequest) {
        EventEntity eventToCreate = eventBuilder()
                .id(eventCreationRequest.getId())
                .host(eventCreationRequest.getHost())
                .location(eventCreationRequest.getLocation())
                .description(eventCreationRequest.getDescription())
                .createdAt(timeSource.getCurrentTime())
                .build();

        EventEntity createdEvent = eventRepo.save(eventToCreate);

        return eventCreationResponseBuilder()
                .id(createdEvent.getId())
                .host(createdEvent.getHost())
                .location(createdEvent.getLocation())
                .description(createdEvent.getDescription())
                .build();
    }

    public EventReadResponse readEvent(EventReadRequest eventReadRequest) {
        EventEntity event = eventRepo.findOne(eventReadRequest.getId());

        return eventReadResponseBuilder()
                .id(event.getId())
                .host(event.getHost())
                .location(event.getLocation())
                .description(event.getDescription())
                .build();
    }

    public List<EventReadResponse> readEvents(EventReadRequest eventReadRequest) {
        List<EventReadResponse> eventReadResponseList = new ArrayList<>();

        Iterable<EventEntity> events = eventRepo.findAll();
        for (EventEntity event : events) {
            eventReadResponseList.add(
                    eventReadResponseBuilder()
                            .id(event.getId())
                            .host(event.getHost())
                            .location(event.getLocation())
                            .description(event.getDescription())
                            .build()
            );
        }

        return eventReadResponseList;
    }
}
