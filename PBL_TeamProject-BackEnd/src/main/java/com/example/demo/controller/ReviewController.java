package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.entity.User;
import com.example.demo.entity.Movie;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 모든 리뷰 조회
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // 리뷰 제목으로 조회
    @GetMapping("/title/{title}")
    public List<Review> getReviewsByTitle(@PathVariable String title) {
        return reviewService.getReviewsByTitle(title);
    }

    // 닉네임으로 조회
    @GetMapping("/nickname/{nickname}")
    public List<Review> getReviewsByNickname(@PathVariable String nickname) {
        return reviewService.getReviewsByNickname(nickname);
    }

    // 추천수가 특정 값 이상인 리뷰 조회
    @GetMapping("/upvotes/{upvotes}")
    public List<Review> getReviewsByUpvotes(@PathVariable Integer upvotes) {
        return reviewService.getReviewsByUpvotes(upvotes);
    }

    // 리뷰 ID로 조회
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 리뷰 생성 또는 업데이트
    @PostMapping
    public Review createOrUpdateReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // 리뷰 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    // 특정 사용자가 작성한 모든 리뷰 조회
    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUser(@PathVariable String userId) {
        User user = new User();
        user.setId(userId);
        return reviewService.getReviewsByUser(user);
    }

    // 특정 영화에 대한 모든 리뷰 조회
    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovie(@PathVariable Long movieId) {
        Movie movie = new Movie();
        movie.setId(movieId);
        return reviewService.getReviewsByMovie(movie);
    }

    // 특정 사용자가 특정 영화에 대해 작성한 리뷰 조회
    @GetMapping("/user/{userId}/movie/{movieId}")
    public List<Review> getReviewsByUserAndMovie(@PathVariable String userId, @PathVariable Long movieId) {
        User user = new User();
        user.setId(userId);
        Movie movie = new Movie();
        movie.setId(movieId);
        return reviewService.getReviewsByUserAndMovie(user, movie);
    }

    // 특정 등급 이상의 리뷰 조회
    @GetMapping("/rating/{rating}")
    public List<Review> getReviewsByRatingGreaterThanEqual(@PathVariable BigDecimal rating) {
        return reviewService.getReviewsByRatingGreaterThanEqual(rating);
    }
    
    // 추천수에 따라 내림차순으로 정렬된 리뷰 조회
    @GetMapping("/sorted/upvotes")
    public List<Review> getReviewsSortedByUpvotes() {
        return reviewService.getReviewsSortedByUpvotes();
    }
}
