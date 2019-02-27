package onenine.android.Model;

import java.util.HashMap;

public class Ship {
    private ShipType shipType;
    private int cargoUsed;
    HashMap<Goods, Integer> tradeGoods = new HashMap<>();

    public Ship (ShipType st) {
        this.shipType = st;
        this.cargoUsed = 0;
        for (Goods good : Goods.values()) {
            this.tradeGoods.put(good, 0);
        }
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int getCargoUsed() {
        return cargoUsed;
    }

    public void setCargoUsed(int cargoUsed) {
        this.cargoUsed = cargoUsed;
    }

    public HashMap<Goods, Integer> getTradeGoods() {
        return tradeGoods;
    }

    public void setTradeGoods(HashMap<Goods, Integer> tradeGoods) {
        this.tradeGoods = tradeGoods;
    }

    public void changeQuantity(Goods good, int newValue) {
        this.tradeGoods.put(good, newValue);
    }
}
