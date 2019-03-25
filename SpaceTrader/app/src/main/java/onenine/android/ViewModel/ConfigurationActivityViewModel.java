package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;
import onenine.android.Model.GameDifficulty;


public class ConfigurationActivityViewModel extends ViewModel {
    private Facade gameFacade = Facade.getInstance();
    public void onConfig(String n, int p, int f, int t, int e, int credits, GameDifficulty difficulty) {
        gameFacade.setPlayer(n, p, f, t, e, credits);
        gameFacade.setGame(difficulty);
    }

}
