package com.example.mockMvc.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest //Coloca o teste dentro de um contexto, web
public class FilmeControllerTest {

    private FilmeController filmeController;

    @BeforeEach //Vai criar o standaloneSetup e injetar em seu contexto, apenas o controller
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(this.filmeController);
    }

    @Test
    void testeDeveRetornarSucesso_QuandoBuscarFilme() {

    }
}
