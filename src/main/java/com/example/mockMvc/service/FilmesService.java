package com.example.mockMvc.service;

import com.example.mockMvc.model.FilmeModel;
import org.springframework.stereotype.Service;

@Service
public class FilmesService {

    public FilmeModel obterFilme(Long codigo) {
        if (codigo > 100) {
            return null;
        }
        return new FilmeModel(codigo, "O Poderoso Chefão", "Filme norte-americano de 1972," +
                "dirigido por Francis Ford Coppola");

    }
}
