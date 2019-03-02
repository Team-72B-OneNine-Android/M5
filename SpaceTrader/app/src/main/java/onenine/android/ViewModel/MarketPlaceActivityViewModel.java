package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.Model.Ship;

public class MarketPlaceActivityViewModel extends ViewModel{
    public Ship getShip() {
        return Facade.getInstance().getGame().getPlayer().getShip();
    }
    public Planet getPlanet() {
        return Facade.getInstance().getGame().getCurrentPlanet();
    }
}
