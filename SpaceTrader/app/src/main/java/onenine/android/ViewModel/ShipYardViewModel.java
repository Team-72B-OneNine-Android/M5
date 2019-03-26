package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;

public class ShipYardViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    private int currentFuel() {
        return gameFacade.myShipFuel();
    }

    public String planetName() {
        return gameFacade.getPlanetType();
    }

    public void chargeForFuel(int i) {
        gameFacade.changeMyCredits(i);
    }

    public void changeFuel(int i) {
        gameFacade.changeShipFuel(i);
    }

    public int planetFuelPrice() {
        return gameFacade.getCurrentPlanetFuelPrice();
    }

    public int fuelCost() {
        return ((100 - this.currentFuel()) * planetFuelPrice());
    }
}
