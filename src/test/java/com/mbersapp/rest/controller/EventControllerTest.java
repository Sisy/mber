package com.mbersapp.rest.controller;

import com.mbersapp.rest.domain.EventCreationRequest;
import com.mbersapp.rest.domain.EventCreationResponse;
import com.mbersapp.rest.domain.EventReadResponse;
import com.mbersapp.rest.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.mbersapp.rest.domain.EventCreationRequest.eventCreationRequestBuilder;
import static com.mbersapp.rest.domain.EventCreationResponse.eventCreationResponseBuilder;
import static com.mbersapp.rest.domain.EventReadRequest.eventReadRequestBuilder;
import static com.mbersapp.rest.domain.EventReadResponse.eventReadResponseBuilder;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class EventControllerTest {

    EventController controller;

    @Mock
    EventService eventService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new EventController(eventService);
    }

    @Test
    public void testCreateEvent() throws Exception {
        EventCreationRequest eventCreationRequest = eventCreationRequestBuilder()
                .id("456")
                .host("shiyue")
                .location("boston")
                .description("great, great")
                .build();
        EventCreationResponse eventCreationResponse = eventCreationResponseBuilder()
                .id("45")
                .host("shiyue")
                .location("boston")
                .description("great")
                .build();
        doReturn(eventCreationResponse).when(eventService).createEvent(eventCreationRequest);
        assertEquals(eventCreationResponse, controller.createEvent(eventCreationRequest));

    }

    @Test
    public void testGetEvents() throws Exception {
        List<EventReadResponse> readResponseList = new ArrayList<>();
        readResponseList.add(eventReadResponseBuilder().id("12").build());

        doReturn(readResponseList).when(eventService).readEvents(eventReadRequestBuilder().build());

        assertEquals(readResponseList, controller.getEvents());

    }

    @Test
    public void testGetEvent() throws Exception {
        EventReadResponse eventReadResponse = eventReadResponseBuilder()
                .id("234")
                .host("shiyue")
                .location("boston")
                .description("this is awesome night")
                .build();

        doReturn(eventReadResponse).when(eventService).readEvent(eventReadRequestBuilder().id("234").build());

        assertEquals(eventReadResponse, controller.getEvent("234"));
    }
}