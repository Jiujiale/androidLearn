package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class TaskPhoto extends AppCompatActivity {

    private Button button;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_photo);

        button = findViewById(R.id.btn_take_photo);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outputImage = new File(getExternalCacheDir(), "outputImage.jpg");
                if (outputImage.exists()) {
                    outputImage.delete();
                }
                try {
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                imageUri = FileProvider.getUriForFile(TaskPhoto.this, "com.example.demo.fileprovider", outputImage);
                imageUri = Uri.fromFile(outputImage);

                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                intent.putExtra(MediaStore.Extra)
            }
        });
    }
}