package com.sd22.datasource.mongodb.repository;

import com.sd22.datasource.mongodb.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "MongoDB")
public interface ReviewMongoDBRepository extends MongoRepository<Review, String> {
}
