package com.example.demo.fragTest2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BBlankFragment extends Fragment {


    public BBlankFragment() {
        // Required empty public constructor
    }

    public static BBlankFragment newInstance() {
        BBlankFragment fragment = new BBlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_blank, container, false);
    }
}