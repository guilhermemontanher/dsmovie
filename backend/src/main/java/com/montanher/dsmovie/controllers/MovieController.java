package com.montanher.dsmovie.controllers;

import com.montanher.dsmovie.dto.MovieDto;
import com.montanher.dsmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public Page<MovieDto> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MovieDto findById(@PathVariable Long id){
        return service.findById(id);
    }
}
