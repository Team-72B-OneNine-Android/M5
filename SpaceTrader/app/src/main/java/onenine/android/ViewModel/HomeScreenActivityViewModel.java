package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.Model.ShipType;

public class HomeScreenActivityViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    /**
     * Gets the player name
     *
     * @return the player's name
     */
    public String getPlayerName() {
        return gameFacade.getPlayerName();
    }

    /**
     * Gets the planet that the player is on
     *
     * @return the planet the player is on
     */
    public Planet getCurrentPlanet() {
        return gameFacade.getCurrentPlanet();
    }

    /**
     * Gets the ship type of the player's ship
     *
     * @return the player's ship type
     */
    public ShipType getShipType() {
        return gameFacade.shipType();
    }

    /**
     * Gets the amount of fuel the player's ship has
     *
     * @return the amount of fuel the player's ship has
     */
    public int getShipFuel() {
        return gameFacade.myShipFuel();
    }

    /**
     * Gets the goods the player has in his or her ship
     *
     * @return the goods the player has in his or her ship
     */
    public String getCurrentGoods() {
        return gameFacade.shipCurrentGoods();
    }
}
