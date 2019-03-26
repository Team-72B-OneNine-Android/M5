package onenine.android.Model;

import java.io.Serializable;
import java.util.Random;

public class Planet implements Serializable {
    private final String type;
    private final TechLevel techLevel;
    private final String resources;
    private final int x;
    private final int y;
    private final Goods[] myGoods= Goods.values();

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
     * gets the planet type
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
     * @return the planet's informations as a string
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
        String goodsProduced = "";
        for (Goods goods : myGoods) {
            if (goods.canBuy()) {
                goodsProduced += goods.getName() + ", ";
            }
        }
        if (goodsProduced.length() <= 0) {
            goodsProduced = "None";
        }
        if (goodsProduced.charAt(goodsProduced.length() - 2) == ',') {
            goodsProduced = goodsProduced.substring(0, goodsProduced.length() - 2);
        }
        return goodsProduced;
    }

    /**
     * Determines the goods used or that can be sold for a planet
     *
     * @return the goods that can be sold for a planet
     */
    public String goodsUsed() {
        String goodsUsed = "";
        for (Goods goods : myGoods) {
            if (goods.canSell()) {
                goodsUsed += goods.getName() + ", ";
            }
        }
        if (goodsUsed.length() <= 0) {
            goodsUsed = "None";
        }
        if (goodsUsed.charAt(goodsUsed.length() - 2) == ',') {
            goodsUsed = goodsUsed.substring(0, goodsUsed.length() - 2);
        }
        return goodsUsed;
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

    /**
     * Calculates the fuel price for a planet
     *
     * @return the fuel price for a planet
     */
    public int fuelPrice() {
        int fuelPrice;
        if ((this.getTechLevelNum() >= 1) && (this.getTechLevelNum() < 4)) {
            fuelPrice = new Random().nextInt(2) + 1;
        } else if ((this.getTechLevelNum() >= 4) && (this.getTechLevelNum() < 7)) {
            fuelPrice = new Random().nextInt(4) + 2;
        } else if (this.getTechLevelNum() == 7) {
            fuelPrice = 5;
        } else {
            fuelPrice = 0;
        }
        return fuelPrice;
    }
}
