package onenine.android.Model;

import java.io.Serializable;

public class Game implements Serializable {

    private final GameDifficulty difficulty;
    private final Player player;
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

    public String getCurrentPlanetType() {
        return currentPlanet.getType();
    }

    public int planetFuelPrice() {
        return currentPlanet.fuelPrice();
    }

    public int myShipFuel() {
        return player.getShipFuel();
    }

    public String currentPlanetGoodsProduced() {
        return currentPlanet.goodsProduced();
    }

    public String currentPlanetGoodsUsed() {
        return currentPlanet.goodsUsed();
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
        if (this.playerCanTravel(p)) {
            if (this.fuelCostForPlanet(p) != 0) {
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
                    if (player.isGoodTrader()) {
                        player.changeCredits(200);
                    } else {
                        player.changeCredits(100);
                    }
                }
            } else {
                randomEvent = Events.NO_EVENT;
            }
            int distance = currentPlanet.calculateDistance(p);
            player.updateShipFuel(distance);
            this.setCurrentPlanet(p);
            return true;
        }
        return false;
    }

    /**
     * Calculates the cost for fuel to travel to a specific planet
     *
     * @param planet the planet to calculate the cost of fuel to travel to
     * @return the cost for fuel to travel
     */
    public int fuelCostForPlanet(Planet planet) {
        int distance = Universe.distanceBetweenTwoPlanets(currentPlanet, planet);
        return distance / 2;
    }

    /**
     * Determines whether the player has greater than zero credits
     *
     * @return whether the player has more than zero credits
     */
    private boolean playerHasCredits() {
        return player.getCredits() > 0;
    }

    /**
     * Determines whether or not the player's ship
     * has cargo
     *
     * @return whether player's ship has cargo
     */
    private boolean shipHasCargo() {
        return player.hasCargo();
    }

    /**
     * Tells whether the player can travel to a specific planet
     *
     * @param planet the planet the player is trying to travel to
     * @return whether the player can travel to a specific planet
     */
    private boolean playerCanTravel(Planet planet) {
        return player.getShipFuel() >= fuelCostForPlanet(planet);
    }

    /**
     * Shows an event message
     *
     * @return an event message as a string
     */
    public String showEventMessage() {
        return Events.getEventMessage(randomEvent);
    }
}