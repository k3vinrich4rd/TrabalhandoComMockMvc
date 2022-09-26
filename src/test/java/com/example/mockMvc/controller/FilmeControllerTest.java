package com.example.mockMvc.controller;

import com.example.mockMvc.model.FilmeModel;
import com.example.mockMvc.service.FilmesService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.*;


@WebMvcTest //Coloca o teste dentro de um contexto, web
public class FilmeControllerTest {

    @Autowired
    private FilmeController filmeController;

    @MockBean
    FilmesService filmesService;

    @BeforeEach //Vai criar o standaloneSetup e injetar em seu contexto, apenas o controller
    //Vai ocorrer antes de cada teste
    public void setup() {
        standaloneSetup(this.filmeController); //Para dar referência somente a classe a filmeController
    }


    @Test
    @DisplayName("O teste deve retornar sucesso quando buscar o filme ")
    void testeDeveRetornarSucesso() {

 /* Anotações e traduções:
      // given = dado
       accept - aceitar
       quando dado essa informação quando fizermos um get no /filmes o status deve ser ok
        */
        when(this.filmesService.obterFilme(1L))
                .thenReturn(new FilmeModel(1L, "O Poderoso chefão", "Sem descrição"));
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("O teste deve retornar não encontrado quando buscar um filme")
    void testeRetornandoNull() {
        when(this.filmesService.obterFilme(5L))
                .thenReturn(null);

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 5L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("O teste deve retornar bad request quando buscar um filme ")
    void testeRetornarBadRequest() {

        given()
                .accept()
                .when()
                .get("/filmes/{codigo}", -1L)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

        verify(this.filmesService, never()).obterFilme(-1L); // Garante que a chamada nunca aconteça
    }


}
