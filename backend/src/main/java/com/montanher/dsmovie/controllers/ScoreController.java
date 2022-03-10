package com.montanher.dsmovie.controllers;

import com.montanher.dsmovie.dto.MovieDto;
import com.montanher.dsmovie.dto.ScoreDTO;
import com.montanher.dsmovie.service.MovieService;
import com.montanher.dsmovie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDto saveScore(@RequestBody ScoreDTO scoreDTO) throws Exception {
        return service.saveScore(scoreDTO);
    }
}
