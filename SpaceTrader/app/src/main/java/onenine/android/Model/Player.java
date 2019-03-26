package onenine.android.Model;

import java.io.Serializable;


public class Player implements Serializable {
    private String name;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int credits;
    private Ship ship;

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, int credits) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = new Ship(ShipType.GNAT);
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    private int getPilotPoints() {
        return pilotPoints;
    }

    private int getFighterPoints() {
        return fighterPoints;
    }

    private int getTraderPoints() {
        return traderPoints;
    }

    private int getEngineerPoints() {
        return engineerPoints;
    }

    public Ship getShip() {
        return ship;
    }

    public int getShipCargoSpace() {
        return this.ship.getCargoSpace();
    }

    public void changeCredits(int credits) {
        this.credits = this.credits + credits;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\n"
                + "Pilot Skill: " + getPilotPoints() + "\n"
                + "Fighter Skill: " + getFighterPoints() + "\n"
                + "Trader Skill: " + getTraderPoints() + "\n"
                + "Engineer Skill: " + getEngineerPoints() + "\n"
                + "Ship Type: " + getShip() + "\n"
                + "Credits: " + getCredits());
    }

    public int updateShipFuel(int i) {
        return ship.decreaseFuel(i);
    }

    public int getShipFuel() {
        return ship.getShipFuel();
    }

    public boolean hasCargo() {
        return ship.getCargoUsed() != 0;
    }

    public void lossOfCargo() {
        ship.emptyCargo();
    }
}