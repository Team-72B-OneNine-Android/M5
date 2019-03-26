package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Player;
import onenine.android.Model.Ship;

public class ShipYardViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    private int currentFuel() {
        return gameFacade.myShipFuel();
    }

    public String planetName() {
        return gameFacade.getPlanetType();
    }

    public int planetFuelPrice() {
        return gameFacade.getCurrentPlanetFuelPrice();
    }

    public int fuelCost() {
        return ((100 - this.currentFuel()) * planetFuelPrice());
    }

    public Player getPlayer() {
        return gameFacade.getPlayer();
    }

    public Ship getShip() {
        return gameFacade.getShip();
    }
}
