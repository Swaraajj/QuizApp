package com.swaraj.quizapp;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

public class Question2 extends Fragment{
    RadioGroup radioGroup;
    ItemViewModel viewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.question2, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup = (RadioGroup)view.findViewById(R.id.q2optgrp);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkid) {
                switch(checkid){
                    case R.id.q2opt1:
                    case R.id.q2opt4:
                    case R.id.q2opt3:
                        viewModel.setData(0);
                        break;
                    case R.id.q2opt2:
                        viewModel.setData(1);
                        break;
                }
            }
        });
    }
}
