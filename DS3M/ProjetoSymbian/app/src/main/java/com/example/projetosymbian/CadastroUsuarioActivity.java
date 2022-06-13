package com.example.projetosymbian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetosymbian.model.Usuario;
import com.example.projetosymbian.remote.APIUtil;
import com.example.projetosymbian.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroUsuarioActivity extends AppCompatActivity {

    //atributos
    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtCelular;
    EditText txtSenha;
    Button btnCadastrar;

    //representação das rotas
    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtCelular = findViewById(R.id.txtCelular);
        txtSenha = findViewById(R.id.txtSenha);
        btnCadastrar = findViewById(R.id.btnCadastrarUsuario);

        //evento de clique - cadastro
        btnCadastrar.setOnClickListener(view -> {

            //objeto da model
            Usuario usuario = new Usuario();

            //carregar dados na model
            usuario.setNome(txtNome.getText().toString());
            usuario.setSobrenome(txtSobrenome.getText().toString());
            usuario.setEmail(txtEmail.getText().toString());
            usuario.setCelular(txtCelular.getText().toString());
            usuario.setSenha(txtSenha.getText().toString());

            //dados para API
            routerInterface = APIUtil.getUsuarioInterface();
            addUsuario(usuario);

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        });

    } //fim do onCreate

    //método addUsuario
    public void addUsuario(Usuario usuario){

        //call
        Call<Usuario> call = routerInterface.addUsuario(usuario);

        //callback
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(CadastroUsuarioActivity.this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable throwable) {
                Log.d("ERRO-API", throwable.getMessage());
            }
        });


    }


}