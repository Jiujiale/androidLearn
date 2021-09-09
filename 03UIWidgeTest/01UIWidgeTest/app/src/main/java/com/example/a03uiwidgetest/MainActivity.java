package com.example.a03uiwidgetest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        editText = (EditText) findViewById(R.id.edit_text);
//        imageView = (ImageView) findViewById(R.id.image_view1);
//        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
//
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("data", "onClick: " + view.getId());
//                if (view.getId() == R.id.button) {
//                    Log.d("data", "true");
//                }
//
//                String inputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_LONG).show();
//
//                imageView.setImageResource(R.drawable.image02);
//
////                if (progressBar.getVisibility() == View.GONE) {
////                    progressBar.setVisibility(View.VISIBLE);
////                } else {
////                    progressBar.setVisibility(View.GONE);
////                }
//
//                int progress = progressBar.getProgress();
//                if (progress >= 100) {
//                    progress = 0;
//                }
//                progress = progress + 10;
//                progressBar.setProgress(progress);
//
////                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
////                dialog.setTitle("This is Dialog");
////                dialog.setMessage("Something important!");
////                dialog.setCancelable(false);
////                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                });
////                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                });
////                dialog.show();
//
//                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//                progressDialog.setTitle("This is ProgressDialog");
//                progressDialog.setMessage("Loading....");
//                progressDialog.setCancelable(false);
//                progressDialog.show();
//            }
//        });

    }

}