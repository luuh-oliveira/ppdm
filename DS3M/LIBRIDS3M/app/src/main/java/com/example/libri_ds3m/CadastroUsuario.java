package com.example.libri_ds3m;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.SQLHelper;
import helpers.DateFormat;

public class CadastroUsuario extends AppCompatActivity {

    /** REPRESENTAÇÃO DOS CAMPOS DA ACTIVITY **/
    private EditText txtNome;
    private EditText txtSobrenome;
    private EditText txtEmail;
    private EditText txtLogin;
    private EditText txtSenha;
    private Button btnCadastrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        /** CAPTURA DOS COMPONENTES GRÁFICOS DA ACTIVITY **/
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnCadastrarUsuario = findViewById(R.id.btnCadastrarUsuario);

        /** TRATAMENTO DO EVENTO DE CLIQUE NO BOTÃO **/

        // view-> = representa a view que sofre a ação do clique
        // {} = corpo do lambda; tratar a ação que queremos executar após o clique

        btnCadastrarUsuario.setOnClickListener(view -> {

            if (!validate()){

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            /** PROCESSO DE GRAVAÇÃO DE USUÁRIO **/
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.tituloCadastroUsuario))
                    .setMessage(getString(R.string.mensagem_cadastro_usuario))
                    .setPositiveButton(R.string.salvar, (dialog1, which)->{
                        /** AÇÃO DO POSITIVE BUTTON **/
                        String nome = txtNome.getText().toString();
                        String sobrenome = txtSobrenome.getText().toString();
                        String email = txtEmail.getText().toString();
                        String login = txtLogin.getText().toString();
                        String senha = txtSenha.getText().toString();

                        /** DATA DE INSERÇÃO DE USUÁRIO **/
                        DateFormat df = new DateFormat();
                        String created_date = df.getDateFormat();

                        boolean cadastroUsuario = SQLHelper.getInstance(this)
                                .addUser(nome, sobrenome, email, login, senha, created_date);

                        if (cadastroUsuario){
                            Toast.makeText(this, "CADASTRO REALIZADO COM SUCESSO", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(this, "ERRO AO REALIZAR O CADASTRO", Toast.LENGTH_LONG).show();
                        }

                    })
                    .setNegativeButton(R.string.cancelar, (dialog1, which)->{}).create();

            dialog.show();

        });


    } // final do OnCreate

    /** MÉTODO DE VALIDAÇÃO **/
    private boolean validate(){

        return(
                !txtNome.getText().toString().isEmpty() &&
                !txtSobrenome.getText().toString().isEmpty() &&
                !txtEmail.getText().toString().isEmpty() &&
                !txtLogin.getText().toString().isEmpty() &&
                !txtSenha.getText().toString().isEmpty()

        ) ;

    }

}