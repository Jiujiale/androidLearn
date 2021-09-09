package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.fragTest.AFrag;
import com.example.demo.fragTest.BFrag;

public class FragmentTest extends AppCompatActivity {

    private Button changeBtn;
    private AFrag aFrag;
    private BFrag bFrag;
    private Boolean showA;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        aFrag = AFrag.newInstance("hello aaaa");

        showA = true;

        getFragmentManager().beginTransaction().add(R.id.frag_bg, aFrag).commitAllowingStateLoss();

        changeBtn = findViewById(R.id.change_frag);

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showA = !showA;
                if (!showA && bFrag == null) {
                    bFrag = new BFrag();
                }
                fragment = showA ? aFrag : bFrag;
                getFragmentManager().beginTransaction().replace(R.id.frag_bg, fragment).commitAllowingStateLoss();

            }
        });
    }
}