package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivityTest extends AppCompatActivity {

    private final String fileName = "test_file.txt";
    private Button btn_save;
    private Button btn_read;
    private EditText editText;
    private TextView textView;

    private Button btn_save_external;
    private Button btn_read_external;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);

        editText = findViewById(R.id.file_data_ed01);
        btn_save = findViewById(R.id.file_data_btn_save);
        btn_read = findViewById(R.id.file_data_btn_read);
        textView = findViewById(R.id.file_data_tv01);

        btn_read_external = findViewById(R.id.file_data_btn_read_external);
        btn_save_external = findViewById(R.id.file_data_btn_save_external);
        textView2 = findViewById(R.id.file_data_tv02);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                writeData(str);
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = readData();
                textView.setText(str);
            }
        });

        btn_save_external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                writeExternalData(data);
            }
        });

        btn_read_external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String str = readExternalData();
               textView2.setText(str);
            }
        });

        isStoragePermissionGranted();
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.d("permission","Permission is granted");
                return true;
            } else {
                Log.d("permission","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.d("permission","Permission is granted");
            return true;
        }
    }

    private void writeData(String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(this.fileName, MODE_PRIVATE);
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readData() {
        FileInputStream fileInputStream = null;
        StringBuilder stringBuilder = null;
        try {
            fileInputStream = openFileInput(this.fileName);
            byte[] bytes = new byte[1024];
            stringBuilder = new StringBuilder("");
            int readCount = 0;
            while ((readCount = fileInputStream.read(bytes)) > 0) {
                stringBuilder.append(new String(bytes, 0 , readCount));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void writeExternalData(String data) {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(getExternalFilesDir(null), "test_dir");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, this.fileName);
            Log.d("permission","file: " + file.getAbsolutePath());

            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readExternalData() {
        FileInputStream fileInputStream = null;
        StringBuilder stringBuilder = null;
        try {
            File file = new File(getExternalFilesDir(null).getAbsolutePath()+File.separator + "test_dir", this.fileName);
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            stringBuilder = new StringBuilder("");
            int readCount = 0;
            while ((readCount = fileInputStream.read(bytes)) > 0) {
                stringBuilder.append(new String(bytes, 0 , readCount));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}