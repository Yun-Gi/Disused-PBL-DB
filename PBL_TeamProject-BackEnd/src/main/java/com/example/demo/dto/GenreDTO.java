// GenreDTO.java
package com.example.demo.dto;

public class GenreDTO {
    private Integer id;         // 장르 테이블의 PK
    private Long movieId;    // 영화 테이블의 FK
    private Integer genreListId; // 장르목록 테이블의 FK

    // 기본 생성자
    public GenreDTO() {}

    // 모든 필드를 초기화하는 생성자
    public GenreDTO(Integer id, Long movieId, Integer genreListId) {
        this.id = id;
        this.movieId = movieId;
        this.genreListId = genreListId;
    }

    // Getter 및 Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getGenreListId() {
        return genreListId;
    }

    public void setGenreListId(Integer genreListId) {
        this.genreListId = genreListId;
    }

    @Override
    public String toString() {
        return "GenreDTO{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", genreListId=" + genreListId +
                '}';
    }
}