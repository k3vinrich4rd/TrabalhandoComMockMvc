package com.example.mockMvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmeModel {
    private Long codigo;
    private String titulo;
    private String descricao;
}
