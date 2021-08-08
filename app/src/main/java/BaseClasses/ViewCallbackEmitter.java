package BaseClasses;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import java.util.ArrayList;
import java.util.List;

public class ViewCallbackEmitter {

    private Lifecycle baseLifeCycle;
    private List<LifecycleObserver> viewCallbackObservers = new ArrayList<>();

    public ViewCallbackEmitter init(Lifecycle lifecycle) {
        baseLifeCycle = lifecycle;
        return this;
    }

    public void addObserver(ViewCallbackObserver viewCallbackObserver) {
        baseLifeCycle.addObserver(viewCallbackObserver);
        this.viewCallbackObservers.add(viewCallbackObserver);
    }

}
