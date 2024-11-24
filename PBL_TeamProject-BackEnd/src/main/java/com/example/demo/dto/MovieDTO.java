package com.example.demo.dto;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    @JsonProperty("movie_title")
    private String name;

    @JsonProperty("TMDB_ID")
    private Long id;

    @JsonProperty("age_rating")
    private String ageRating;

    private String synopsis;

    @JsonProperty("rating")
    private BigDecimal movieRating;

    @JsonProperty("tmdb_score")
    private BigDecimal score;

    @JsonProperty("runtime")
    private Integer runningTime;

    @JsonProperty("poster_URL")
    private String poster;

    private String director;

    private String genres;  // 연결된 장르 목록

    // 기본 생성자, Getter 및 Setter
    public MovieDTO() {}

    // 모든 필드를 초기화하는 생성자
    public MovieDTO(Long id, String name, String ageRating, String synopsis,
                    BigDecimal movieRating, BigDecimal score,
                    Integer runningTime, String poster, String director,
                    String genres) {
        this.id = id;
        this.name = name;
        this.ageRating = ageRating;
        this.synopsis = synopsis;
        this.movieRating = movieRating;
        this.score = score;
        this.runningTime = runningTime;
        this.poster = poster;
        this.director = director;
        this.genres = genres;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public BigDecimal getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(BigDecimal movieRating) {
        this.movieRating = movieRating;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

}
