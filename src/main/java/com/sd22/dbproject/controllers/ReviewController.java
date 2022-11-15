package com.sd22.dbproject.controllers;

import com.sd22.dbproject.entities.Review;
import com.sd22.dbproject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //Get all reviews
    @GetMapping("/")
    public List<Review> getReview() {
        return reviewService.getReviews();
    }

    //Add a review
    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    //Find review by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> findReviewById(@PathVariable int id) {
        Optional<Review> review = reviewService.findReviewById(id);
        if (review.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(review);
        } else {
            return ResponseEntity.ok(review);
        }
    }

    //DELETE review by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Review> review = reviewService.findReviewById(id);
        if (review.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'review " + id + " not found'}");
        }
        reviewService.deleteReviewById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }

    //PUT,update review by id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Review requestReview) {
        Optional<Review> review = reviewService.findReviewById(id);
        if (review.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'review " + id + " not found'}");
        }
        reviewService.updateReview(requestReview);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");
    }
}
