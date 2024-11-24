package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite_list")
public class FavoriteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 자동 증가 설정

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 기본 생성자
    public FavoriteList() {}

    // 필드를 사용하는 생성자
    public FavoriteList(Movie movie, User user) {
        this.movie = movie;
        this.user = user;
    }

    // Getter 및 Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
