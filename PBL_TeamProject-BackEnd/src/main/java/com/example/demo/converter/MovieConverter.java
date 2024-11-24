/*package com.example.demo.converter;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Movie;
import com.example.demo.entity.Cast;
import com.example.demo.entity.Actor;
import com.example.demo.service.MovieService;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MovieConverter {

    @Autowired
    private ActorService actorService;

    public void processCastInformation(Movie movie, String castInfo) {
        List<String> castNames = Arrays.asList(castInfo.split(","));
        for (String name : castNames) {
            // 예: "톰 하디 (Eddie Brock / Venom)"에서 배우 이름만 추출
            String actorName = name.split("\\(")[0].trim();
            Actor actor = actorService.findOrCreateActorByName(actorName);

            Cast cast = new Cast();
            cast.setMovie(movie);
            cast.setActor(actor);
            movie.getCasts().add(cast);
        }
    }

}*/

