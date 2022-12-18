package com.sd22.datasource.mongodb.repositories;

import com.sd22.datasource.mongodb.entities.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "MongoDB")
public interface TripMongoDBRepository extends MongoRepository<Trip, String> {
}