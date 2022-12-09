package com.sd22.database.neo4j.controller;

import com.sd22.database.neo4j.service.ReviewService;
import com.sd22.database.neo4j.entity.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getAll(){
        return reviewService.getAll();
    }

    @PostMapping("/reviews")
    public Review createTrip(@RequestParam Review review){
        return reviewService.save(review);
    }

    @DeleteMapping("/delete")
    public void deleteTrip(@RequestParam("title") String title){
        reviewService.delete(title);
    }
}
