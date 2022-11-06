package com.sd22.dbproject.services;

import com.sd22.dbproject.models.Review;
import com.sd22.dbproject.repositories.ReviewRepository;
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
}
