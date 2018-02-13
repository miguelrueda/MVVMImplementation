package com.example.Ex1;

import com.example.rxjavamvvm.IViewModel;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ViewModel implements IViewModel<Model> {

    public final BehaviorSubject<String> vm2v_info = BehaviorSubject.create();
    public final Subject<String> vm2v_info2 = ReplaySubject.create();

    public ViewModel() {
        wireInternally();
    }

    private void wireInternally() {
        // NO OP
    }

    @Override
    public void connectTo(Model model) {
//        model.infos().subscribe(vm2v_info);
        model.infos().subscribe(vm2v_info2);
    }
}
