package onenine.android.Model;

public class Player {
    private String name;
//    private String difficulty; //will be an enum
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int credits = 1000;
    private String ship;

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = "Gnat";

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int points) {
        this.pilotPoints = points;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFigterPoints(int points) {
        this.fighterPoints = points;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int points) {
        this.traderPoints = points;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public void setEngineerPoints(int points) {
        this.engineerPoints = points;
    }

    public String getShip() {
        return this.ship;
    }

    public void setShip(String shipType) {
        this.ship = shipType;
    }
}
