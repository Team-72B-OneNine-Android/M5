package onenine.android.Model;

public class Planet {
    private String type;
    private TechLevel techLevel;
    private String resources;
    private int x;
    private int y;
    private Goods[] myGoods= Goods.values();

    public Planet(String type, TechLevel techLevel, String resources, int x, int y) {
        this.type = type;
        this.techLevel = techLevel;
        this.resources = resources;
        this.x = x;
        this.y = y;
    }

    public String getType() {
        return type;
    }
    public TechLevel getTechLevel() {
        return techLevel;
    }
    public int getTechLevelNum() {
        return techLevel.ordinal();
    }
    public String getResources() {
        return resources;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getCoordinateString() {
        return (Integer.toString(getX()) + Integer.toString(getY()));
    }

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

    /*
    This method is used in the home screen activity class
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
                || (this.x == planet.x && this.y == planet.y);
    }

    public int calculateDistance(Planet planet) {
        int xDiff = 0;
        int yDiff = 0;
        int x1 = this.getX();
        int x2 = planet.getX();
        int y1 = this.getY();
        int y2 = planet.getY();
        xDiff = x2 - x1;
        yDiff = y2 - y1;
        return (int) Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));
    }
}
