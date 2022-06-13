package com.example.projetosymbian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //atributos
    EditText txtEmail;
    EditText txtSenha;
    Button btnEntrar;
    Button btnSemCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtEmail = findViewById(R.id.txtEmailLogin);
        txtSenha = findViewById(R.id.txtSenhaLogin);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSemCadastro = findViewById(R.id.btnSemCadastro);

        btnSemCadastro.setOnClickListener(view -> {

            Intent intent = new Intent(this, CadastroUsuarioActivity.class);
            startActivity(intent);

        });

    }



}