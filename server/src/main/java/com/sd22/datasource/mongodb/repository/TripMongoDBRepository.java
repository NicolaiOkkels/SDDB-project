package com.sd22.datasource.mongodb.repository;

import com.sd22.datasource.mongodb.entity.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "MongoDB")
public interface TripMongoDBRepository extends MongoRepository<Trip, String> {
}