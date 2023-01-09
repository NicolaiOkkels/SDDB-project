package com.sd22.datasource.mongodb.controller;


import com.sd22.datasource.mongodb.service.ReviewMongoDBService;
import com.sd22.datasource.mongodb.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/mongo/reviews")
public class ReviewMongoDBController {

    @Autowired
    ReviewMongoDBService reviewMongoDBService;

    @Autowired
    public ReviewMongoDBController(ReviewMongoDBService ReviewMongoDBService){
        this.reviewMongoDBService = reviewMongoDBService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            List<Review> reviews = new ArrayList<>();
            reviews.addAll(reviewMongoDBService.findAll());

            if (reviews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        try {
            Review reviewSaved = reviewMongoDBService.save(review);
            return new ResponseEntity<>(reviewSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") String id, @RequestBody Review review) {
        Optional<Review> reviewData = Optional.ofNullable(reviewMongoDBService.findReviewById(id));

        if (reviewData.isPresent()) {
            Review _review = reviewData.get();
            _review.setId(review.getId());
            _review.setTitle(review.getTitle());
            _review.setTrip(review.getTrip());
            _review.setUser(review.getUser());
            _review.setRating(review.getRating());
            return new ResponseEntity<>(reviewMongoDBService.updateReview(_review), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable String id) {
        try {
            Review review = reviewMongoDBService.findReviewById(id);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable("id") String id) {
        try {
            reviewMongoDBService.deleteReviewById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}