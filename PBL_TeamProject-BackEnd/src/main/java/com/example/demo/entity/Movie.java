package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;//1

import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    private Long id;  // TMDB ID를 사용

    @Column(nullable = false, length = 45) // NOT NULL 및 최대 길이 설정
    private String name;

    @Column(length = 512) // URL을 저장할 충분한 길이로 설정
    private String poster; // 포스터 URL

    @Column(nullable = false, length = 45)
    private String director;

    @Column(precision = 2, scale = 1)
    private BigDecimal movieRating; // DECIMAL(2,1) 타입

    @Column
    private Integer runningTime; // 러닝타임

    @Column
    private String ageRating; // String 타입

    @Column(precision = 7, scale = 3)
    private BigDecimal score; // 스코어

    @Column(columnDefinition = "TEXT")
    private String synopsis; // TEXT 타입

    @OneToMany(mappedBy = "movie")
    private Set<Cast> casts = new HashSet<>();//1

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Genre> genres;


    // 기본 생성자
    public Movie() {}

    public Movie(Long id, String name, String poster, String director, BigDecimal movieRating,
                 Integer runningTime, String ageRating, BigDecimal score, String synopsis) {
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.director = director;
        this.movieRating = movieRating;
        this.runningTime = runningTime;
        this.ageRating = ageRating;
        this.score = score;
        this.synopsis = synopsis;
    }

    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(BigDecimal movieRating) {
        this.movieRating = movieRating;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Set<Cast> getCasts() {
        return casts;
    } //1

    public void setCasts(Set<Cast> casts) {
        this.casts = casts;
    } //1

    public Set<Genre> getGenres() {
        return genres;
    }//1

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }//1
}
