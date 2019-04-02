package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;

public class ShipYardViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    /**
     * Gets the fuel the player has in ship
     *
     * @return the amount of fuel the player has in ship
     */
    private int currentFuel() {
        return gameFacade.myShipFuel();
    }

    /**
     * Gets the planet type for the planet the player is on
     *
     * @return the planet type for the planet the player is on
     */
    public String planetName() {
        return gameFacade.getPlanetType();
    }

    /**
     * Updates the player credits once more fuel is bought
     *
     * @param i amount to deduct from the player's credits
     */
    public void chargeForFuel(int i) {
        gameFacade.changeMyCredits(i);
    }

    /**
     * Updates the amount of fuel for the player's ship
     *
     * @param i amount of fuel to update the player's ship to have
     */
    public void changeFuel(int i) {
        gameFacade.changeShipFuel(i);
    }

    /**
     * Gets the fuel price for the planet the player is on
     *
     * @return the fuel price for the planet the player is on
     */
    public int planetFuelPrice() {
        return gameFacade.getCurrentPlanetFuelPrice();
    }

    /**
     * calculates fuel cost
     *
     * @return cost for fuel when on current planet
     */
    public int fuelCost() {
        return ((100 - this.currentFuel()) * planetFuelPrice());
    }
}
