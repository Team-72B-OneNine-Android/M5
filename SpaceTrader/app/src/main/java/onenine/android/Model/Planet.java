package onenine.android.Model;

import java.io.Serializable;
import java.util.Random;

/**
 * Planet class
 */
public class Planet implements Serializable {
    private final String type;
    private final TechLevel techLevel;
    private final String resources;
    private final int x;
    private final int y;
    private final Goods[] myGoods= Goods.values();
    private final Facade gameFacade = Facade.getInstance();

    /**
     * Planet constructor
     *
     * @param type the planet type
     * @param techLevel the planet tech level
     * @param resources the planet resource type
     * @param x the planet x coordinate
     * @param y the planet y coordinate
     */
    public Planet(String type, TechLevel techLevel, String resources, int x, int y) {
        this.type = type;
        this.techLevel = techLevel;
        this.resources = resources;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the planet type
     *
     * @return planet type as a string
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the planet tech level
     *
     * @return the planet's tech level type
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Gets the planets tech level number
     *
     * @return the planets tech level number
     */
    public int getTechLevelNum() {
        return techLevel.ordinal();
    }

    /**
     * Gets the planet resource type
     *
     * @return the planets resource type
     */
    public String getResources() {
        return resources;
    }

    /**
     * Gets the planets x coordinate
     *
     * @return the planets x coordinate
     */
    private int getX() {
        return x;
    }

    /**
     * Gets the planets y coordinate
     *
     * @return the planets y coordinate
     */
    private int getY() {
        return y;
    }

    /**
     * Displays the planet's information
     *
     * @return the planet's information as a string
     */
    @Override
    public String toString() {
        return ("Planet Name: " + getType() + "\n"
                + "Tech Level: " + getTechLevel() + "\n"
                + "Tech Level Number: " + getTechLevelNum() + "\n"
                + "Resource Type: " + getResources() + "\n"
                + "X Coordinate: " + getX() + "\n"
                + "Y Coordinate: " + getY() + "\n"
                + "Coordinates: " + ("(") + getX() + (", ") + getY() + (")") + "\n");
    }

    /**
     * Determines the goods that are produced for a planet
     *
     * @return the goods produced on a planet
     */
    public String goodsProduced() {
        StringBuilder goodsProduced = new StringBuilder();
        for (Goods goods : myGoods) {
            if (goods.canBuy()) {
                goodsProduced.append(goods.getName()).append(", ");
            }
        }
        if (goodsProduced.length() <= 0) {
            goodsProduced = new StringBuilder("None");
        }
        if (goodsProduced.charAt(goodsProduced.length() - 2) == ',') {
            goodsProduced = new StringBuilder(goodsProduced.substring(
                    0, goodsProduced.length() - 2));
        }
        return goodsProduced.toString();
    }

    /**
     * Determines the goods used or that can be sold for a planet
     *
     * @return the goods that can be sold for a planet
     */
    public String goodsUsed() {
        StringBuilder goodsUsed = new StringBuilder();
        for (Goods goods : myGoods) {
            if (goods.canSell()) {
                goodsUsed.append(goods.getName()).append(", ");
            }
        }
        if (goodsUsed.length() <= 0) {
            goodsUsed = new StringBuilder("None");
        }
        if (goodsUsed.charAt(goodsUsed.length() - 2) == ',') {
            goodsUsed = new StringBuilder(goodsUsed.substring(0, goodsUsed.length() - 2));
        }
        return goodsUsed.toString();
    }


    /**
     * Displays the coordinates of a planet in a readable format
     *
     * @return a formatted version of a planet's coordinates
     */
    public String coordinatesPretty() {
        return ("(") + getX() + (", ") + getY() + (")");
    }

    public boolean equals (Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Planet)) {
            return false;
        }
        Planet planet = (Planet) o;
        return this.type.equals(planet.type)
                || ((this.x == planet.x) && (this.y == planet.y));
    }

    public int hashCode() {
        int hash = 7;
        hash = (31 * hash) + x;
        hash = (31 * hash) + y;
        hash = (31 * hash) + ((type == null) ? 0 : type.hashCode());
        return hash;
    }

    /**
     * Calculates the distance between the current planet and a given planet
     *
     * @param planet the planet to calculate the distance to
     * @return the distance between the current planet and a given planet
     */
    public int calculateDistance(Planet planet) {
        int xDiff;
        int yDiff;
        int x1 = this.getX();
        int x2 = planet.getX();
        int y1 = this.getY();
        int y2 = planet.getY();
        xDiff = x2 - x1;
        yDiff = y2 - y1;
        return (int) Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));
    }

    private boolean playerGoodTrader() {
        return gameFacade.goodTrader();
    }

    /**
     * Calculates the fuel price for a planet
     *
     * @return the fuel price for a planet
     */
    public int fuelPrice() {
        int fuelPrice;
        if ((this.getTechLevelNum() >= 1) && (this.getTechLevelNum() < 4)) {
            if (playerGoodTrader()) {
                fuelPrice = 1;
            } else {
                fuelPrice = new Random().nextInt(2) + 1;
            }
        } else if ((this.getTechLevelNum() >= 4) && (this.getTechLevelNum() < 7)) {
            if (playerGoodTrader()) {
                fuelPrice = 2;
            } else {
                fuelPrice = new Random().nextInt(4) + 2;
            }
        } else if (this.getTechLevelNum() == 7) {
            if (playerGoodTrader()) {
                fuelPrice = 4;
            } else {
                fuelPrice = 5;
            }
        } else {
            fuelPrice = 0;
        }
        return fuelPrice;
    }
}
