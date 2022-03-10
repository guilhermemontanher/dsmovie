package com.montanher.dsmovie.service;

import com.montanher.dsmovie.dto.MovieDto;
import com.montanher.dsmovie.dto.ScoreDTO;
import com.montanher.dsmovie.entities.Movie;
import com.montanher.dsmovie.entities.Score;
import com.montanher.dsmovie.entities.User;
import com.montanher.dsmovie.repositories.MovieRepository;
import com.montanher.dsmovie.repositories.ScoreRepository;
import com.montanher.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDto saveScore(ScoreDTO scoreDTO) throws Exception {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if(user == null) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            userRepository.saveAndFlush(user);
        }

        Optional<Movie> movieObj = movieRepository.findById(scoreDTO.getMovieId());
        Movie movie;
        if(movieObj.isPresent()){
            movie = movieObj.get();
        } else {
            throw new Exception("Movie not found");
        }

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s: movie.getScores()){
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movie = movieRepository.save(movie);
        return new MovieDto(movie);
    }

}

