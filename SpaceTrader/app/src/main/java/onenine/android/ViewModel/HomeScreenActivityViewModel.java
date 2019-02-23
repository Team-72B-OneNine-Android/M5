package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Universe;

public class HomeScreenActivityViewModel extends ViewModel {
    public Universe getUniverse() {
        return Facade.getInstance().getUniverse();
    }

}
