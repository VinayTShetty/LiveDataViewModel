package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Integer> score;

    public MutableLiveData<Integer> getScore() {
        if (score == null) {
            score = new MutableLiveData<>();
            resetScore();
        }
        return score;
    }

    public void resetScore() {
        /**
         * This set value is used if we are assigining the value in the main Thread
         */
        score.setValue(0);
        /**
         * This post value is used if we are assigining the value on the worker Thread.
         */
//        score.postValue(0);
    }
    public void addScore(){
       if(score!=null){
          score.setValue(score.getValue()+1);
       }
    }
}
