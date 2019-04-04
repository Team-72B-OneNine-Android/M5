package onenine.android.Model;

import java.io.Serializable;
import java.util.HashMap;

public class Ship implements Serializable {
    private final ShipType shipType;
    private int cargoUsed;
    private int shipFuel;
    private final HashMap<Goods, Integer> tradeGoods = new HashMap<>();

    /**
     * Ship constructor
     *
     * @param st the ship type to set the ship as
     */
    public Ship (ShipType st) {
        this.shipType = st;
        this.cargoUsed = 0;
        this.shipFuel = 100;
        for (Goods good : Goods.values()) {
            this.tradeGoods.put(good, 0);
        }
    }

    /**
     * Gets the ship type
     *
     * @return the ship type
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * Gets the amoutn of cargo used on the ship
     *
     * @return the amount of cargo used
     */
    public int getCargoUsed() {
        return cargoUsed;
    }

    /**
     * Sets the amount of cargo used on the ship
     *
     * @param cargoUsed the amount of cargo to give the ship
     */
    public void setCargoUsed(int cargoUsed) {
        this.cargoUsed = cargoUsed;
    }

    /**
     * Gets the amount of fuel for ship
     *
     * @return the amount of fuel a ship has
     */
    public int getShipFuel() {
        return shipFuel;
    }

    /**
     * Sets amount of fuel for a ship
     *
     * @param shipFuel the amount of fuel to give a ship
     */
    public void setShipFuel(int shipFuel) {
        this.shipFuel = shipFuel;
    }

    /**
     * Gets the trade goods
     *
     * @return trade goos for a ship
     */
    public HashMap<Goods, Integer> getTradeGoods() {
        return tradeGoods;
    }

    /**
     * Gets the amount of cargo space remaining for a ship
     *
     * @return the amount of cargo space that a ship has
     */
    public int getCargoSpace() {
        return shipType.getCargoSpace() - cargoUsed;
    }

    /**
     * Determines whether there is cargo space available for a ship
     *
     * @return wheter or not cargo space is available for a ship
     */
    public boolean cargoSpaceAvailable() {
        return cargoUsed < shipType.getCargoSpace();
    }

    /**
     * Gets the goods that are currently on the ship
     *
     * @return the goods that are currently on the ship
     */
    public String currentGoods() {
        StringBuilder currentGoods = new StringBuilder();
        for (Goods goods : tradeGoods.keySet()) {
            if (tradeGoods.get(goods) != 0) {
                currentGoods.append(goods.getName()).append(" = ").append(tradeGoods.get(goods)).append(", ");
            }
        }
        if (currentGoods.length() <= 0) {
            currentGoods = new StringBuilder("None");
        }
        if (currentGoods.charAt(currentGoods.length() - 2) == ',') {
            currentGoods = new StringBuilder(currentGoods.substring(0, currentGoods.length() - 2));
        }
        return currentGoods.toString();
    }

    /**
     * Decreases fuel for a ship based on a provided distance
     *
     * @param fuelCost the amount of fuel required to travel
     * @return the amount the fuel should be decreased by
     */
    public void decreaseFuel(int fuelCost) {
        shipFuel = shipFuel - fuelCost;
    }

    /**
     * Empties the cargo for a ship
     */
    public void emptyCargo() {
        if (cargoUsed != 0) {
            for (Goods goods : tradeGoods.keySet()) {
                tradeGoods.replace(goods, 0);
            }
            this.cargoUsed = 0;
        }
    }
}
