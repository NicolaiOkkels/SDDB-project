package com.sd22.datasource.mongodb.service;

import com.sd22.datasource.mongodb.entity.Review;
import com.sd22.datasource.mongodb.repository.ReviewMongoDBRepository;

import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReviewMongoDBService {

    ReviewMongoDBRepository reviewMongoDBRepository;

    @Autowired
    public ReviewMongoDBService(ReviewMongoDBRepository reviewMongoDBRepository){
        this.reviewMongoDBRepository = reviewMongoDBRepository;
    }

    public Review save(Review review) {
        return reviewMongoDBRepository.save(review);
    }

    public Collection<? extends Review> findAll() {
        return reviewMongoDBRepository.findAll();
    }

    public Review findReviewById(String id) {
        return reviewMongoDBRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteReviewById(String id) {
        reviewMongoDBRepository.deleteById(id);
    }

    public Review updateReview(Review review){
        return reviewMongoDBRepository.save(review);
    }
}
