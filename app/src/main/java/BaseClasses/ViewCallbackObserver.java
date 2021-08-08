package BaseClasses;

import androidx.lifecycle.LifecycleObserver;

public interface ViewCallbackObserver extends LifecycleObserver {

    default void onHidden() {}
    default void onBackPressed() {}
    default void onOptionsItemSelected() {}

}
