package onenine.android.Model;

import java.io.Serializable;
import java.util.HashMap;

public class Ship implements Serializable {
    private ShipType shipType;
    private int cargoUsed;
    private int shipFuel;
    private HashMap<Goods, Integer> tradeGoods = new HashMap<>();

    public Ship (ShipType st) {
        this.shipType = st;
        this.cargoUsed = 0;
        this.shipFuel = 100;
        for (Goods good : Goods.values()) {
            this.tradeGoods.put(good, 0);
        }
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getCargoUsed() {
        return cargoUsed;
    }

    public void setCargoUsed(int cargoUsed) {
        this.cargoUsed = cargoUsed;
    }
    public int getShipFuel() {
        return shipFuel;
    }

    public void setShipFuel(int shipFuel) {
        this.shipFuel = shipFuel;
    }

    public HashMap<Goods, Integer> getTradeGoods() {
        return tradeGoods;
    }

    public int getCargoSpace() {
        return shipType.getCargoSpace() - cargoUsed;
    }

    public boolean cargoSpaceAvailable() {
        return cargoUsed < shipType.getCargoSpace();
    }

    public String currentGoods() {
        String currentGoods = "";
        for (Goods goods : tradeGoods.keySet()) {
            if (tradeGoods.get(goods) != 0) {
                currentGoods += goods.getName() + " = " + tradeGoods.get(goods) + ", ";
            }
        }
        if (currentGoods.length() <= 0) {
            currentGoods = "None";
        }
        if (currentGoods.charAt(currentGoods.length() - 2) == ',') {
            currentGoods = currentGoods.substring(0, currentGoods.length() - 2);
        }
        return currentGoods;
    }

    public int decreaseFuel(int distance) {
        int percentDecrease = distance / 2;
        shipFuel = shipFuel - percentDecrease;
        return shipFuel;
    }

    public void emptyCargo() {
        if (cargoUsed != 0) {
            for (Goods goods : tradeGoods.keySet()) {
                tradeGoods.replace(goods, 0);
            }
            this.cargoUsed = 0;
        }
    }
}
