package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    Button addScoreButton, resetScoreButton;
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        buttonOnClickListner();
        /**
         * ViewModel Instance
         */
        getViewModelInstance();
        attachLiveDataObserver();
    }

    private void getViewModelInstance(){
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

    private void attachLiveDataObserver(){
        mainActivityViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                scoreTextView.setText(String.valueOf(integer));
            }
        });
    }

    private void addScore(){
        mainActivityViewModel.addScore();
    }
    private void resetScore(){
        mainActivityViewModel.resetScore();
    }
    private void buttonOnClickListner(){
        addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore();
            }
        });
        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });
    }
    private void initializeViews(){
        scoreTextView = findViewById(R.id.scoreTextView);
        addScoreButton = findViewById(R.id.addScoreButton);
        resetScoreButton = findViewById(R.id.resetScoreButton);
    }
}