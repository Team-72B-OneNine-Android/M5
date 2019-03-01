package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;

import java.util.HashMap;
import onenine.android.Model.Facade;
import onenine.android.Model.Game;
import onenine.android.Model.Goods;

public class GoodsViewModel extends ViewModel {
    public HashMap<Goods, Integer> getGoodsMap() {
        return Facade.getInstance().goodsMap();
    }
    public Goods[] getGoods() {
        return Goods.values();
    }
    public Game getGame() {
        return Facade.getInstance().getGame();
    }
}
