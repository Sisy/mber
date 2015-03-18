package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Primary
@Repository
public class MongoEventRepository implements EventRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoEventRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public EventEntity create(EventEntity event) {
        mongoTemplate.save(event);
        return event;
    }

    @Override
    public List<EventEntity> readAll() {
        return mongoTemplate.findAll(EventEntity.class);
    }

    @Override
    public EventEntity read(String id) {
        return mongoTemplate.findOne(query(where("id").is(id)), EventEntity.class);
    }
}
