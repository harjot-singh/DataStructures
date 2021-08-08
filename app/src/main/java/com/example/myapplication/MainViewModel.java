package com.example.myapplication;

import android.database.Observable;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends Lifecycle {

    List list = new ArrayList();


    @Override
    public void addObserver(@NonNull LifecycleObserver observer) {
        //"\uD83D\uDE02\uD83D\uDC4C\uD83C\uDFFB\uD83D\uDE0A\uD83D\uDE18\uD83D\uDE18\uD83D\uDE18\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE01"
    }

    @Override
    public void removeObserver(@NonNull LifecycleObserver observer) {
        //list.add();

    }

    @NonNull
    @Override
    public State getCurrentState() {
        return null;
    }
}
