package com.example.myapplication;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import javax.inject.Inject;

import BaseClasses.BaseLifecycleModel;
import BaseClasses.UnboundViewEventBus;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MySampleFirstViewModel extends BaseLifecycleModel {
    UnboundViewEventBus eventBus;



    @Inject
    public  MySampleFirstViewModel(UnboundViewEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public  void onCreate() {


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        subscribeOnLifeCycle(Observable.just(3).subscribe());
    }
}
