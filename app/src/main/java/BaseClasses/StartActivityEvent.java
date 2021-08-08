package BaseClasses;

import android.content.Intent;
import android.net.Uri;

import java.util.Objects;

public class StartActivityEvent extends BaseUnboundViewEvent {
    private Intent intent;
    private Uri intentUri;
    public String intentAction ;
    private Class startActivityClassz;

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Uri getIntentUri() {
        return intentUri;
    }

    public void setIntentUri(Uri intentUri) {
        this.intentUri = intentUri;
    }

    public String getIntentAction() {
        return intentAction;
    }

    public void setIntentAction(String intentAction) {
        this.intentAction = intentAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StartActivityEvent)) return false;
        StartActivityEvent that = (StartActivityEvent) o;
        return intent.equals(that.intent) &&
                intentUri.equals(that.intentUri) &&
                intentAction.equals(that.intentAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intent, intentUri, intentAction);
    }

    public Class<?> getStartActivity() {
        return startActivityClassz;
    }
}
