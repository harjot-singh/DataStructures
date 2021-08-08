package BaseClasses;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseActivity extends AppCompatActivity {

    @Nullable
    protected CompositeDisposable registerUnboundViewEvents() {
        return null;
    }

    private final ViewCallbackEmitter viewCallbackEmitter = new ViewCallbackEmitter();
    private final CompositeDisposable lifeCycleSubscriptions  = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public ViewCallbackEmitter getViewCallbackEmitter() {
        return viewCallbackEmitter.init(getLifecycle());
    }

    protected void subscribeOnLifecycle(Disposable disposable) {
        lifeCycleSubscriptions.add(disposable);
    }

    private void subscribeToEventBus() {
        lifeCycleSubscriptions.clear();
        CompositeDisposable eventsSubscriptionV2 = registerUnboundViewEvents();

        if(eventsSubscriptionV2 != null) {
            lifeCycleSubscriptions.add(eventsSubscriptionV2);
        }
    }

    protected void startActivity(StartActivityEvent event) {
        Intent startIntent = new Intent(this, event.getStartActivity());
        startActivity(startIntent);
    }
}
