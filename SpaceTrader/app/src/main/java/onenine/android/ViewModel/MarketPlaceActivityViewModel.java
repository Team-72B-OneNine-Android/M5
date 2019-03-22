package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.Model.Ship;

public class MarketPlaceActivityViewModel extends ViewModel{

    private final Facade gameFacade = Facade.getInstance();

    public Ship getShip() {
        return gameFacade.getShip();
    }

    public Planet getPlanet() {
        return gameFacade.getCurrentPlanet();
    }
}
