package onenine.android.Model;

import java.io.Serializable;

public class Game implements Serializable {

    private GameDifficulty difficulty;
    private Player player;
    private Planet currentPlanet;
    private Events randomEvent;

    /**
     * Game constructor
     *
     * @param p the current player
     * @param difficulty the game difficulty
     */
    public Game(Player p, GameDifficulty difficulty) {
        this.player = p;
        this.difficulty = difficulty;
    }

    /**
     * Gets the game's player
     *
     * @return the current player of game
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the current planet of game
     *
     * @return the planet the player is currently on
     * in the game
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * Sets the planet the player is currently on in the game
     *
     * @param currentPlanet the planet to set the games planet to
     */
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    /**
     * Shows the player information and game difficulty
     *
     * @return the player info and game difficulty as
     * a string
     */
    @Override
    public String toString() {
        return player.toString() + "\n" + "Game Difficulty: " + difficulty.toString();
    }

    /**
     * Determines whether the player can travel.
     * If player can travel, then a random event is created.
     *
     * @param p the planet to check whether player can travel to
     * @return whether the player can travel to a specific planet
     */
    public boolean travel(Planet p) {
        if ((this.fuelCostForPlanet(p) != 0) && this.playerCanTravel(p)) {
            randomEvent = Events.checkForEvent();
            if (randomEvent == Events.LOSE_CARGO) {
                if (this.shipHasCargo()) {
                    player.lossOfCargo();
                } else {
                    randomEvent = Events.NO_EVENT;
                }
            }
            if (randomEvent == Events.LOSE_CREDIT) {
                if (this.playerHasCredits()) {
                    if (!(player.getCredits() <= 0)) {
                        player.changeCredits(-100);
                    }
                } else {
                    randomEvent = Events.NO_EVENT;
                }
            }
            if (randomEvent == Events.GAIN_CREDIT) {
                player.changeCredits(100);
            }
            int distance = currentPlanet.calculateDistance(p);
            player.updateShipFuel(distance);
            this.setCurrentPlanet(p);
            return true;
        }
        return false;
    }

    public int fuelCostForPlanet(Planet planet) {
        int distance = Universe.distanceBetweenTwoPlanets(currentPlanet, planet);
        return distance / 2;
    }

    private boolean playerHasCredits() {
        return player.getCredits() > 0;
    }

    private boolean shipHasCargo() {
        return player.hasCargo();
    }

    private boolean playerCanTravel(Planet planet) {
        return player.getShipFuel() >= fuelCostForPlanet(planet);
    }
    public String showEventMessage() {
        return Events.getEventMessage(randomEvent);
    }
}