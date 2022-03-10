package com.montanher.dsmovie.service;

import com.montanher.dsmovie.dto.MovieDto;
import com.montanher.dsmovie.entities.Movie;
import com.montanher.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable){
        Page<Movie> result = repository.findAll(pageable);
        return result.map(MovieDto::new);
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id){
        Movie result = repository.findById(id).get();
        return new MovieDto(result);
    }
}

