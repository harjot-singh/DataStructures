package BaseClasses;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseLifecycleModel implements ViewCallbackObserver {

    private ViewCallbackEmitter viewCallbackEmitter;
    private CompositeDisposable lifeCycleSubscriptions = new CompositeDisposable();

    public void setViewCallbackEmitter(ViewCallbackEmitter viewCallbackEmitter) {
        this.viewCallbackEmitter = viewCallbackEmitter;
    }

    public ViewCallbackEmitter getViewCallbackEmitter() {
        return viewCallbackEmitter;
    }

    protected void subscribeOnLifeCycle(Disposable disposable) {
        lifeCycleSubscriptions.add(disposable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        lifeCycleSubscriptions.clear();
    }
}
