package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.Model.Ship;

public class HomeScreenActivityViewModel extends ViewModel {

    Facade gameFacade = Facade.getInstance();

    public String getPlayerName() {
        return gameFacade.getPlayerName();
    }

    public Planet getCurrentPlanet() {
        return gameFacade.getCurrentPlanet();
    }

    public Ship getShip() {
        return gameFacade.getShip();
    }
}
