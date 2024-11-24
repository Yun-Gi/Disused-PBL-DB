package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Genre;
import com.example.demo.entity.GenreList;
import com.example.demo.entity.Movie;
import com.example.demo.repository.GenreListRepository;
import com.example.demo.repository.MovieRepository;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private final GenreListRepository genreListRepository;

    // 모든 영화 조회
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 영화 ID로 영화 조회
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // 영화 저장 또는 업데이트
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    // MovieDTO를 인수로 받는 메서드 추가
    public Movie saveMovie(MovieDTO movieDTO) {
        // DTO를 엔티티로 변환
        Movie movie = JsonDataLoader.convertToMovieEntity(movieDTO);
        return saveMovie(movie);
    }

    // 영화 삭제
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // 영화 제목으로 영화 조회
    public List<Movie> getMoviesByName(String name) {
        return movieRepository.findByName(name);
    }

    // 감독 이름으로 영화 조회
    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    // 특정 등급 이상의 영화 조회
    public List<Movie> getMoviesByRatingGreaterThan(BigDecimal rating) {
        return movieRepository.findByMovieRatingGreaterThan(rating);
    }

    // 제목에 특정 문자열이 포함된 영화 조회
    public List<Movie> getMoviesByNameContaining(String keyword) {
        return movieRepository.findByNameContaining(keyword);
    }

    // 스코어에 따라 내림차순으로 정렬된 영화 조회
    public List<Movie> getMoviesSortedByScore() {
        return movieRepository.findAllByOrderByScoreDesc();
    }

    // 특정 연령 등급의 영화 조회
    public List<Movie> getMoviesByAgeRating(String ageRating) {
        return movieRepository.findByAgeRating(ageRating);
    }

    public MovieService(MovieRepository movieRepository, GenreListRepository genreListRepository) {
        this.movieRepository = movieRepository;
        this.genreListRepository = genreListRepository;
    }

}
