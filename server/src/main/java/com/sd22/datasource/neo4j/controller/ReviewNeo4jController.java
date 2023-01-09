package com.sd22.datasource.neo4j.controller;

import com.sd22.datasource.neo4j.service.ReviewNeo4jService;
import com.sd22.datasource.neo4j.entity.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/rest/neo4j/review")
public class ReviewNeo4jController {

    private final ReviewNeo4jService reviewNeo4jService;

    public ReviewNeo4jController(ReviewNeo4jService reviewNeo4jService) {
        this.reviewNeo4jService = reviewNeo4jService;
    }

    @GetMapping("/")
    public Review getReviewById(@RequestParam("id") String id){
        Optional<Review> reviewOpt = reviewNeo4jService.getReviewById(Long.parseLong(id));
        if(reviewOpt.isPresent()){
            return reviewOpt.get();
        }
        throw new NoSuchElementException("No review found with given id");
    }

    @GetMapping("/reviews")
    public List<Review> getAll(){
        return reviewNeo4jService.getAll();
    }

    @GetMapping("/badReviews")
    public List<Review> getBadReviews(){
        return reviewNeo4jService.getBadReviews();
    }

    @PostMapping("/reviews")
    public Review createReview(@RequestBody Review review){
        return reviewNeo4jService.save(review);
    }

    @DeleteMapping("/delete")
    public void deleteReview(@RequestParam("id") String id){
        reviewNeo4jService.delete(Long.parseLong(id));
    }

    @PutMapping("/update")
    public Review update(@RequestBody Review review) {
       return reviewNeo4jService.save(review);
    }
}
