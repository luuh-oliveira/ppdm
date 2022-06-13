package com.example.projetosymbian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("id_usuario")
    //expõe um atributo para que eles possam ser manipulados pelo gson
    @Expose
    private int id_usuario;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("sobrenome")
    @Expose
    private String sobrenome;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("celular")
    @Expose
    private String celular;

    @SerializedName("senha")
    @Expose
    private String senha;


    //construtor
    public Usuario(){
    }

    public Usuario(int id_usuario, String nome, String sobrenome, String email, String senha,  String celular){
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
    }



    //getters e setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
