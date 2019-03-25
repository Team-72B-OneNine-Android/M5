package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Game;

public class GoodsViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    public Game getGame() {
        return gameFacade.getGame();
    }

    public int getCredits() {return gameFacade.getPlayerCredits();}

    public int getCargoSpaceAvailable() {
        return gameFacade.getShip().getCargoSpace();
    }
}
