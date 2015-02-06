package com.mbersapp.rest.controller;

import com.mbersapp.rest.domain.EventCreationRequest;
import com.mbersapp.rest.domain.EventCreationResponse;
import com.mbersapp.rest.domain.EventReadResponse;
import com.mbersapp.rest.model.EventEntity;
import com.mbersapp.rest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mbersapp.rest.domain.EventReadRequest.eventReadRequestBuilder;

@RestController
public class EventController {

    private Map<String, EventEntity> events = new HashMap<>();

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public EventCreationResponse createEvent(@RequestBody EventCreationRequest eventCreationRequest) {
        return eventService.createEvent(eventCreationRequest);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<EventReadResponse> getEvents() {
        return eventService.readEvents(eventReadRequestBuilder().build());
    }

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public EventReadResponse getEvent(@PathVariable String eventId) {
        return eventService.readEvent(eventReadRequestBuilder().id(eventId).build());
    }
}
