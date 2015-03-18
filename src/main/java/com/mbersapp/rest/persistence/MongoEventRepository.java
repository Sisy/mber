package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class MongoEventRepository implements EventRepository {

    private final DBCollection eventsCollection;
    private final MongoConverter mongoConverter;

    @Autowired
    public MongoEventRepository(DB mongoDb, MongoTemplate mongoTemplate) {
        eventsCollection = mongoDb.getCollection("events");
        mongoConverter = mongoTemplate.getConverter();
    }

    @Override
    public EventEntity create(EventEntity event) {
        persist(event);
        return event;
    }

    @Override
    public List<EventEntity> readAll() {
        List<EventEntity> events = new ArrayList<>();

        DBCursor cursor = eventsCollection.find();
        while (cursor.hasNext()) {
            events.add(buildEvent(cursor.next()));
        }

        return events;
    }

    @Override
    public EventEntity read(String id) {
        DBObject dbObject = eventsCollection.findOne(new BasicDBObject("id", id));
        return buildEvent(dbObject);
    }

    private void persist(EventEntity event) {
        DBObject dbObject = new BasicDBObject();
        mongoConverter.write(event, dbObject);
        eventsCollection.insert(dbObject);
    }

    private EventEntity buildEvent(DBObject dbObject) {
        return mongoConverter.read(EventEntity.class, dbObject);
    }
}
