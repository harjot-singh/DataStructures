package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import BaseClasses.BaseActivity;
import BaseClasses.UnboundViewEventBus;
import io.reactivex.disposables.CompositeDisposable;

public class MySampleFirstActivity extends BaseActivity {

    @Inject
    UnboundViewEventBus eventBus;

    @Inject
    MySampleFirstViewModel mySampleFirstViewModell;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AndroidInjection.inject(this);
        //Add layout binding:: Activity...Binding  binding  = DataBinddingUtil.setCon,.
        mySampleFirstViewModell.setViewCallbackEmitter(getViewCallbackEmitter());

        //binding.setViewModel(
    }

    @Nullable
    @Override
    protected CompositeDisposable registerUnboundViewEvents() {
        CompositeDisposable events = new CompositeDisposable();
        events.add(eventBus.startActivity(MySampleFirstViewModel.class).subscribe(this::startActivity));

        return events;
    }
}
