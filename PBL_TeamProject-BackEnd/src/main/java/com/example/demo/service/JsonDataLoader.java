package com.example.demo.service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Genre;
import com.example.demo.entity.GenreList;
import com.example.demo.entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class JsonDataLoader {

    private final MovieService movieService;
    private final GenreListService genreListService;
    private final GenreService genreService;

    @Value("${movie.json.path}")
    private String movieJsonFilePath;

    public JsonDataLoader(MovieService movieService, GenreListService genreListService, GenreService genreService) {
        this.movieService = movieService;
        this.genreListService = genreListService;
        this.genreService = genreService;
    }

    public void loadFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 1. JSON 파일에서 영화 데이터 읽기
            File movieFile = new ClassPathResource(movieJsonFilePath).getFile();
            List<MovieDTO> movieDTOs = objectMapper.readValue(
                movieFile,
                objectMapper.getTypeFactory().constructCollectionType(List.class, MovieDTO.class)
            );

            // 2. DTO → Entity 변환 및 데이터베이스 저장
            for (MovieDTO movieDTO : movieDTOs) {
                // 2-1. 영화 저장
                Movie movie = convertToMovieEntity(movieDTO);
                movieService.saveMovie(movie);

                // 2-2. 장르 처리
                String genresStr = movieDTO.getGenres(); // String 타입의 장르 데이터
                List<String> genreNames = Arrays.asList(genresStr.split(",")); // String을 List<String>으로 변환
                Set<GenreList> genreLists = processGenres(genreNames);
                for (GenreList genreList : genreLists) {
                    Genre genre = new Genre();
                    genre.setGenreList(genreList); // GenreList 연결
                    genre.setMovie(movie);        // Movie 연결
                    genreService.saveGenre(genre); // Genre 저장
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // JSON 데이터에서 장르 처리
    private Set<GenreList> processGenres(List<String> genreNames) {
        Set<GenreList> genreLists = new HashSet<>();

        for (String genreName : genreNames) {
            GenreList genreList = genreListService.getGenreListsByGenre(genreName)
                    .orElseGet(() -> {
                        // 장르가 없으면 새로 저장
                        GenreList newGenre = new GenreList();
                        newGenre.setGenre(genreName);
                        return genreListService.saveGenreList(newGenre);
                    });
            genreLists.add(genreList);
        }

        return genreLists;
    }

    // MovieDTO → Movie 변환
    static Movie convertToMovieEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setId(movieDTO.getId());
        movie.setAgeRating(movieDTO.getAgeRating());
        movie.setSynopsis(movieDTO.getSynopsis());
        movie.setMovieRating(movieDTO.getMovieRating());
        movie.setScore(movieDTO.getScore());
        movie.setRunningTime(movieDTO.getRunningTime());
        movie.setPoster(movieDTO.getPoster());
        movie.setDirector(movieDTO.getDirector());
        // 필요한 필드 추가 설정
        return movie;
    }
}
