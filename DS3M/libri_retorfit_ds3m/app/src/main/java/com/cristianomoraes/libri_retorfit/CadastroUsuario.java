package com.cristianomoraes.libri_retorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Usuario;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroUsuario extends AppCompatActivity {

    /** ATRIBUTOS - INTERFACE GRÁFICA **/
    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtLogin;
    EditText txtSenha;
    Button btnInserir;

    /** ATRIBUTO - REPRESENTAÇÃO DAS ROTAS **/
    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        /** RECEBIMENTO - OBJETOS DE INTERFACE **/
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnInserir = findViewById(R.id.btnCadastrarUsuario);

        /** TRATAMENTO - EVENTO DE CLIQUE NO BOTÃO INSERIR **/
        btnInserir.setOnClickListener(view -> {

            /** CRIA UM OBJETO DA MODEL DE USUÁRIO **/
            Usuario usuario = new Usuario();

            /** CARREGA OS DADOS DO FORM NO OBJETO DA MODEL **/
            usuario.setNome(txtNome.getText().toString());
            usuario.setSobrenome(txtSobrenome.getText().toString());
            usuario.setEmail(txtEmail.getText().toString());
            usuario.setLogin(txtLogin.getText().toString());
            usuario.setSenha(txtSenha.getText().toString());

            /** PASSAR OS DADOS PARA A API REST **/

            routerInterface = APIUtil.getUsuarioInterface();
            addUsuario(usuario);

        });

    } // fim do onCreate

    /** IMPLEMENTAÇÃO DO MÉTODO addUsuario **/
    public void addUsuario(Usuario usuario){

        Call<Usuario> call = routerInterface.addUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(CadastroUsuario.this, "USUÁRIO INSERIDO COM SUCESSO", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("ERRO-API", t.getMessage());

            }
        });

    }




}