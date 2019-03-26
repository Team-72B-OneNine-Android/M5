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

    /**
     * Player constructor
     *
     * @param name the player name
     * @param pilotPoints the players pilot points
     * @param fighterPoints the players fighter points
     * @param traderPoints the players trader points
     * @param engineerPoints the players engineer points
     * @param credits
     */
    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, int credits) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = new Ship(ShipType.GNAT);
        this.credits = credits;
    }

    /**
     * Gets player name
     *
     * @return players name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets player pilot points
     *
     * @return players pilot points
     */
    private int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Gets player fighter points
     *
     * @return players fighter points
     */
    private int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Gets player trader points
     *
     * @return players trader points
     */
    private int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Gets player engineer points
     *
     * @return players engineer points
     */
    private int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Gets player's ship
     *
     * @return player's ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Gets the ship type of the players ship
     *
     * @return player's ship type
     */
    public ShipType myShipType() {
        return ship.getShipType();
    }

    /**
     * Gets the goods that are currently on player's ship
     *
     * @return player's goods
     */
    public String myCurrentGoods() {
        return ship.currentGoods();
    }

    /**
     * Gets the player's ship cargo space
     *
     * @return player's cargo space
     */
    public int getShipCargoSpace() {
        return this.ship.getCargoSpace();
    }

    /**
     * Changes the amount of fuel the ship has
     *
     * @param fuel amount of fuel to set the player's ship to have
     */
    public void changeMyFuel(int fuel) {
        ship.setShipFuel(fuel);
    }

    /**
     * Changes the amount of credits a player has
     *
     * @param credits the amount of credits to set for the player
     */
    public void changeCredits(int credits) {
        this.credits = this.credits + credits;
    }

    /**
     * Gets the amount of credits the player has
     *
     * @return the player's credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Displays the information for a player
     *
     * @return the player's information
     */
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

    /**
     * Decreases the fuel in a player's ship
     *
     * @param i the amount to decrease the fuel by
     * @return
     */
    public int updateShipFuel(int i) {
        return ship.decreaseFuel(i);
    }

    /**
     * Gets the amount of fuel the player has
     *
     * @return the amount of fuel the player has for ship
     */
    public int getShipFuel() {
        return ship.getShipFuel();
    }

    /**
     * Determines whether a player's ship has cargo
     *
     * @return whether the player's ship has cargo
     */
    public boolean hasCargo() {
        return ship.getCargoUsed() != 0;
    }

    /**
     * Empties all cargo in a player's ship
     */
    public void lossOfCargo() {
        ship.emptyCargo();
    }
}