package com.mbersapp.rest.service;

import com.mbersapp.rest.persistence.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class EventServiceTest {

    EventService service;

    @Mock
    EventRepository repo;

    @Before
    public void setUp() throws Exception {
        service = new EventService(repo);
    }

    @Test
    public void testCreateEvent() throws Exception {

    }

    @Test
    public void testReadEvent() throws Exception {

    }

    @Test
    public void testReadEvents() throws Exception {

    }
}