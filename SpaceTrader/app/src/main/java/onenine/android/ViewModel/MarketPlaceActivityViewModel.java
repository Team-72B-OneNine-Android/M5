package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;

public class MarketPlaceActivityViewModel extends ViewModel{

    private final Facade gameFacade = Facade.getInstance();

    public String getCurrentGoods() {
        return gameFacade.shipCurrentGoods();
    }

    public String getGoodsProduced() {
        return gameFacade.planetGoodsProduced();
    }

    public String getGoodsUsed() {
        return gameFacade.planetGoodsUsed();
    }

}
