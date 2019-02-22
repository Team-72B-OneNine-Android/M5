package onenine.android.Model;

public class Planet {
    private String type;
    private String techLevel;
    private String resources;
    private int x;
    private int y;

    public Planet(String type, String techLevel, String resources, int x, int y) {
        this.type = type;
        this.techLevel = techLevel;
        this.resources = resources;
        this.x = x;
        this.y = y;
    }

    public String getType() {
        return type;
    }
    public String getTechLevel() {
        return techLevel;
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
    public String getCoordinateSum() {
        return (Integer.toString(getX()) + Integer.toString(getY()));
    }

}
