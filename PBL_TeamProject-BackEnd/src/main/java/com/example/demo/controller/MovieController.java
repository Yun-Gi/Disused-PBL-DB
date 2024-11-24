package com.example.demo.controller;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    // 모든 영화 조회
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // 영화 ID로 조회
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 영화 생성 또는 업데이트
    @PostMapping
    public Movie createOrUpdateMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    // 영화 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    // 영화 제목으로 조회
    @GetMapping("/title/{name}")
    public List<Movie> getMoviesByName(@PathVariable String name) {
        return movieService.getMoviesByName(name);
    }

    // 감독 이름으로 영화 조회
    @GetMapping("/director/{director}")
    public List<Movie> getMoviesByDirector(@PathVariable String director) {
        return movieService.getMoviesByDirector(director);
    }

    // 특정 등급 이상의 영화 조회
    @GetMapping("/rating/{rating}")
    public List<Movie> getMoviesByRatingGreaterThan(@PathVariable BigDecimal rating) {
        return movieService.getMoviesByRatingGreaterThan(rating);
    }

    // 제목에 특정 문자열이 포함된 영화 조회
    @GetMapping("/search/{keyword}")
    public List<Movie> getMoviesByNameContaining(@PathVariable String keyword) {
        return movieService.getMoviesByNameContaining(keyword);
    }
    
    // 특정 연령 등급의 영화 조회
    @GetMapping("/age-rating/{ageRating}")
    public List<Movie> getMoviesByAgeRating(@PathVariable String ageRating) {
        return movieService.getMoviesByAgeRating(ageRating);
    }

    // 스코어에 따라 내림차순으로 정렬된 영화 조회
    @GetMapping("/sorted/score")
    public List<Movie> getMoviesSortedByScore() {
        return movieService.getMoviesSortedByScore();
    }

      public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * JSON 데이터를 받는 엔드포인트
     */
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO) {
        try {
            // 서비스 계층을 통해 데이터를 저장
            movieService.saveMovie(movieDTO);
            return ResponseEntity.ok("Movie data has been saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error while saving movie: " + e.getMessage());
                                }
                            }
                        }
                    