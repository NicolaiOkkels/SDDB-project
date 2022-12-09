package com.sd22.database.neo4j.service;

import com.sd22.database.neo4j.entity.Review;
import com.sd22.database.neo4j.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAll(){
        return reviewRepository.findAll();
    }

    public void delete(String title){
        reviewRepository.deleteById(title);
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }
}
