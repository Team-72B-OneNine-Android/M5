package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.Model.ShipType;

public class HomeScreenActivityViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    public String getPlayerName() {
        return gameFacade.getPlayerName();
    }

    public Planet getCurrentPlanet() {
        return gameFacade.getCurrentPlanet();
    }

    public ShipType getShipType() {
        return gameFacade.shipType();
    }

    public int getShipFuel() {
        return gameFacade.myShipFuel();
    }

    public String getCurrentGoods() {
        return gameFacade.shipCurrentGoods();
    }
}
