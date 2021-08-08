package BaseClasses;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

@Singleton
public class UnboundViewEventBus {
    private final PublishSubject<StartActivityEvent> startActivityEventPublishSubject = PublishSubject.create();

    @Inject
    UnboundViewEventBus() {

    }


    public void send(StartActivityEvent startActivityEvent) {
        startActivityEventPublishSubject.onNext(startActivityEvent);
    }

    public Observable<StartActivityEvent> startActivity(Object viewModel) {
        return startActivity(viewModel.getClass());
    }

    public Observable<StartActivityEvent> startActivity(Class viewModelClass) {
        return startActivityEventPublishSubject.filter( event -> fromEmitter(event, viewModelClass));
    }

    private boolean fromEmitter(BaseUnboundViewEvent event, Class viewModelClass) {
        return viewModelClass.getName().equals((event).getEmitter().getClass().getName());
    }
}
