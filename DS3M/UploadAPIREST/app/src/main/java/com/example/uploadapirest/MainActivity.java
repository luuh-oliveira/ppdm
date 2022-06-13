package com.example.uploadapirest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imgLivro;
    EditText txtTitulo;
    Button btnCadastrar;
    private final int GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLivro = findViewById(R.id.imgLivro);
        txtTitulo = findViewById(R.id.txtTitulo);
        btnCadastrar= findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");

            startActivityForResult(Intent.createChooser(intent, "SELECIONE UMA IMAGEM"), GALLERY);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_CANCELED){
            return;
        }

        if (requestCode == GALLERY){

            if (data != null){

                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    imgLivro.setImageBitmap(bitmap);

                    Log.d("IMAGEM", "IMAGEM ALTERADA");

                } catch (IOException e) {
                    e.printStackTrace();

                    Log.d("IMAGEM", e.getMessage());
                }

            }

        }

    }
}