package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Game;
import onenine.android.Model.Universe;

public class SpaceStationActivityViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    public Game getGame() {
        return gameFacade.getGame();
    }

    public Universe getUniverse() {
        return gameFacade.getUniverse();
    }

}