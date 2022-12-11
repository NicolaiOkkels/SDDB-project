package com.sd22.datasource.mysql.controller;

import com.sd22.datasource.mysql.entity.Review;
import com.sd22.datasource.mysql.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //Get all reviews
    @GetMapping("/")
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //Add a review
    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review newReview = reviewService.addReview(review);
        return new ResponseEntity<>(newReview,HttpStatus.CREATED);
    }

    //Find review by id
    @GetMapping("/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable int id) {
        Review review = reviewService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    //DELETE review by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Review> delete(@PathVariable("id") int id) {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT, update by id
    @PutMapping("/update")
    public ResponseEntity<Review> update(@RequestBody Review review) {
        Review updateReview = reviewService.updateReview(review);
        return new ResponseEntity<>(updateReview, HttpStatus.OK);
    }
}
