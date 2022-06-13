package com.example.projetosymbian.remote;

import com.example.projetosymbian.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    //interface - apenas descreve atributos e métodos

    /** ROTAS DE USUÁRIO **/
    @POST("/usuario/cadastrarUsuario")
    Call<Usuario> addUsuario(@Body Usuario usuario);

}
