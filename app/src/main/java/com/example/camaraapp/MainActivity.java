package com.example.camaraapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton boton = findViewById(R.id.imageButton1);
        boton.setOnClickListener(l->abrirCamara());

    }
    private static final int REQUEST_IMAGE_CAPTURE=2;
    void abrirCamara(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentCamera, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle info = data.getExtras();
            Bitmap imagen = (Bitmap) info.get("data");

            ImageView imageView= findViewById(R.id.imageView2);
            imageView.setImageBitmap(imagen);
        }
    }
}