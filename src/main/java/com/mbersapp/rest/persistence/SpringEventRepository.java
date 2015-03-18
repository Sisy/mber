package com.mbersapp.rest.persistence;

import com.mbersapp.rest.model.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpringEventRepository extends CrudRepository<EventEntity, String> {
}
