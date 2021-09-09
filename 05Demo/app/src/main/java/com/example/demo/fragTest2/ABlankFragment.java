package com.example.demo.fragTest2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ABlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ABlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private TextView textView;
    private Button nextBtn;
    private Button changeBtn;
    private Button passBtn;

    public MyClickListener myClickListener;
    public PassData passData;

    public ABlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ABlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ABlankFragment newInstance(String param1, MyClickListener listener) {
        ABlankFragment fragment = new ABlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.myClickListener = listener;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            passData = (PassData) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("need implement PassData.passStr function");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (textView == null) {
            textView = view.findViewById(R.id.frag2_tv);
            textView.setText(mParam1);
        }
        Log.d("data", "onViewCreated: hashcode" + textView.hashCode());

        if (nextBtn == null) {
            nextBtn = view.findViewById(R.id.frag2_next);
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickListener.clickCB();
                }
            });
        }

        if (changeBtn == null) {
            changeBtn = view.findViewById(R.id.frag2_change_context);
            changeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    textView.setText("changed text" + Math.random());
                }
            });
        }

        if (passBtn == null) {
            passBtn = view.findViewById(R.id.frag2_pass);
            passBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    ((FragStackTest)getActivity()).updateTv("passed data" + Math.random());
                    passData.passStr("passed data" + Math.random());
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_blank, container, false);
    }

    public interface MyClickListener {
        void clickCB();
    }

    public interface PassData {
        void passStr(String str);
    }
}