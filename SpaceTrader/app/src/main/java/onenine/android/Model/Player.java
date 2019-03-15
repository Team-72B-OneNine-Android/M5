package onenine.android.Model;

import java.io.Serializable;
import java.util.HashMap;

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

    public void setFighterPoints(int points) {
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

    public Ship getShip() {
        return ship;
    }

    public int changeCredits(int credits) {
        this.credits = this.credits + credits;
        return this.credits;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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

    public void lossOfCargo() {
        ship.emptyCargo();
    }
}
