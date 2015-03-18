package com.mbersapp.rest.service;

import com.mbersapp.rest.domain.EventCreationRequest;
import com.mbersapp.rest.domain.EventCreationResponse;
import com.mbersapp.rest.domain.EventReadRequest;
import com.mbersapp.rest.domain.EventReadResponse;
import com.mbersapp.rest.model.EventEntity;
import com.mbersapp.rest.persistence.SpringEventRepository;
import com.mbersapp.rest.utils.TimeSource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mbersapp.rest.domain.EventCreationRequest.eventCreationRequestBuilder;
import static com.mbersapp.rest.domain.EventCreationResponse.eventCreationResponseBuilder;
import static com.mbersapp.rest.domain.EventReadRequest.eventReadRequestBuilder;
import static com.mbersapp.rest.domain.EventReadResponse.eventReadResponseBuilder;
import static com.mbersapp.rest.model.EventEntity.eventBuilder;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class EventServiceTest {

    EventService service;

    @Mock
    SpringEventRepository repo;

    @Mock
    TimeSource timeSource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        service = new EventService(repo, timeSource);

        doReturn(new Date(1424733652)).when(timeSource).getCurrentTime();
    }

    @Test
    public void testCreateEvent() throws Exception {
        EventCreationRequest eventCreationRequest = eventCreationRequestBuilder()
                .id("1")
                .host("shiyue")
                .location("boston")
                .description("nice")
                .build();

        EventEntity createdEvent = eventBuilder()
                .id("2")
                .host("cory")
                .location("denver")
                .description("bad")
                .build();

        doReturn(createdEvent).when(repo).save(any(EventEntity.class));

        EventCreationResponse actualResponse = service.createEvent(eventCreationRequest);

        EventCreationResponse expectedResponse = eventCreationResponseBuilder()
                .id("2")
                .host("cory")
                .location("denver")
                .description("bad")
                .build();

        assertEquals(expectedResponse, actualResponse);

        verify(repo).save(eventBuilder()
                .id("1")
                .host("shiyue")
                .location("boston")
                .description("nice")
                .createdAt(new Date(1424733652))
                .build());
    }

    @Test
    public void testReadEvent() throws Exception {

        EventReadRequest eventReadRequest = eventReadRequestBuilder()
                .id("1")
                .build();
        EventEntity event = eventBuilder()
                .id("1")
                .host("sd")
                .location("sb")
                .description("sb could be sb")
                .build();
        EventReadResponse eventReadResponse = eventReadResponseBuilder()
                .id("1")
                .host("sd")
                .location("sb")
                .description("sb could be sb")
                .build();

        doReturn(event).when(repo).findOne(eventReadRequest.getId());
        assertEquals(eventReadResponse,service.readEvent(eventReadRequest));

    }



    @Test
    public void testReadEvents() throws Exception {
        List<EventReadResponse> eventReadResponseList = new ArrayList<>();
        eventReadResponseList.add(eventReadResponseBuilder()
                .id("1")
                .host("sd")
                .location("sb")
                .description("sb could be sb")
                .build());

        eventReadResponseList.add(eventReadResponseBuilder()
                .id("2")
                .host("sd")
                .location("sb")
                .description("sd could be sb")
                .build());

        EventReadRequest eventReadRequest = eventReadRequestBuilder()
                .id("1")
                .build();

        EventEntity event = eventBuilder()
                .id("1")
                .host("sd")
                .location("sb")
                .description("sb could be sb")
                .build();
        EventEntity event1 = eventBuilder()
                .id("2")
                .host("sd")
                .location("sb")
                .description("sd could be sb")
                .build();
        doReturn(asList(event, event1)).when(repo).findAll();

        assertEquals(eventReadResponseList,service.readEvents(eventReadRequest));
    }
}