package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;

public class MarketPlaceActivityViewModel extends ViewModel{

    private final Facade gameFacade = Facade.getInstance();

    /**
     * Gets the goods that the player has
     *
     * @return the goods the player has in his or her ship
     */
    public String getCurrentGoods() {
        return gameFacade.shipCurrentGoods();
    }

    /**
     * Gets the goods produced on the planet the player is on
     *
     * @return the goods produced on the planet the player is on
     */
    public String getGoodsProduced() {
        return gameFacade.planetGoodsProduced();
    }

    /**
     * Gets the goods used on planet the player is on
     *
     * @return the goods used on the planet the player is on
     */
    public String getGoodsUsed() {
        return gameFacade.planetGoodsUsed();
    }

}
