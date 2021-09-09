package com.example.demo.fragTest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demo.R;

public class AFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afrag_layout, container, false);
        return view;
    }

    public static AFrag newInstance(String string) {
        AFrag aFrag = new AFrag();
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        aFrag.setArguments(bundle);
        return aFrag;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            TextView tv = view.findViewById(R.id.afrag_tv1);
            tv.setText(getArguments().getString("title"));
        }
    }
}
