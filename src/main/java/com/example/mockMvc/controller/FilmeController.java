package com.example.mockMvc.controller;

import com.example.mockMvc.model.FilmeModel;
import com.example.mockMvc.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmes")
public class FilmeController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<FilmeModel> obterFilme(@PathVariable Long codigo) {

        if (codigo < 0) {
            return ResponseEntity.badRequest().build();
        }

        FilmeModel filmeModel = this.filmesService.obterFilme(codigo);

        if (filmeModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filmeModel);
    }

}
