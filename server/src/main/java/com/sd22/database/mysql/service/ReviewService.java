package com.sd22.database.mysql.service;

import com.sd22.database.mysql.entity.Review;
import com.sd22.database.mysql.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public Optional<Review> findReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Review review){
        return reviewRepository.save(review);
    }
}