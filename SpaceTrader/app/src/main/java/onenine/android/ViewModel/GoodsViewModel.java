package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import onenine.android.Model.Facade;
import onenine.android.Model.Game;
import onenine.android.Model.Player;

public class GoodsViewModel extends ViewModel {
    public Game getGame() {
        return Facade.getInstance().getGame();
    }
    public Player getPlayer() {
        return this.getGame().getPlayer();
    }
    public int getCredits() {return this.getPlayer().getCredits();}
    public int getCargoSpaceAvailable() {
        return this.getPlayer().getShip().getCargoSpace();
    }
}
