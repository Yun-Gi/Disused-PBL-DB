package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GenreList;


public interface GenreListRepository extends JpaRepository<GenreList, Integer> {

    // 장르 이름으로 장르 목록 조회
    Optional<GenreList> findByGenre(String genre);

    // 장르 이름에 특정 문자열이 포함된 장르 목록 조회
    List<GenreList> findByGenreContaining(String keyword);

}
