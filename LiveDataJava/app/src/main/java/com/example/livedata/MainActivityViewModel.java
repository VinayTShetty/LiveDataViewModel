package com.example.livedata;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private Integer score;

    public Integer getScore() {
        if (score == null) {
            return 0;
        }
        return score;
    }

    public void addScore() {
        if (score == null) {
            score = 1;
        }
        score += 1;
    }

    public Integer resetScore() {
        score = 0;
        return score;
    }
}
