package onenine.android.Model;

public class Planet {
    private String type;
    private TechLevel techLevel;
    private String resources;
    private int x;
    private int y;

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

}
