package com.sd22.datasource.neo4j.service;

import com.sd22.datasource.neo4j.entity.Review;
import com.sd22.datasource.neo4j.repository.ReviewNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewNeo4jService {

    @Autowired
    private ReviewNeo4jRepository reviewNeo4jRepository;

    @Transactional("neo4jTransactionManager")
    public List<Review> getAll(){
        return reviewNeo4jRepository.findAll();
    }

    @Transactional("neo4jTransactionManager")
    public void delete(Long id){
        reviewNeo4jRepository.deleteById(id);
    }

    @Transactional("neo4jTransactionManager")
    public Optional<Review> getReviewById(Long id) {
        return reviewNeo4jRepository.findById(id);
    }

    @Transactional("neo4jTransactionManager")
    public List<Review> getBadReviews(){
        return reviewNeo4jRepository.getBadReviews();
    }

    @Transactional("neo4jTransactionManager")
    public Review save(Review review){
        return reviewNeo4jRepository.save(review);
    }
}
