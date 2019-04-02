package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Game;

public class GoodsViewModel extends ViewModel {

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
     * Gets the player's credits
     *
     * @return the amount of credits the player has
     */
    public int getCredits() {return gameFacade.getPlayerCredits();}

    /**
     * Gets the cargo space available for the player
     *
     * @return the amount of cargo space available for the player
     */
    public int getCargoSpaceAvailable() {
        return gameFacade.cargoSpace();
    }
}
