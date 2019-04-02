package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Game;
import onenine.android.Model.Planet;

public class SpaceStationActivityViewModel extends ViewModel {

    private final Facade gameFacade = Facade.getInstance();

    /**
     * Gets the current game
     *
     * @return the current game
     */
    public Game getGame() {
        return gameFacade.getGame();
    }

    /**
     * Gets a specific planet
     *
     * @param i the index of the planet to get
     * @return a specific planet
     */
    public Planet getPlanetAtIndex(int i) {
        return gameFacade.getPlanet(i);
    }


}