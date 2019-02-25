package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;
import onenine.android.Model.GameDifficulty;
import onenine.android.Model.Universe;


public class ConfigurationActivityViewModel extends ViewModel {
    public void onConfig(String n, int p, int f, int t, int e, String ship, int credits, GameDifficulty difficulty) {
        Facade.getInstance().setPlayer(n, p, f, t, e, ship, credits);
        Facade.getInstance().setGame(difficulty);
        Facade.getInstance().setUniverse();
    }

}
