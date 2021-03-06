package onenine.android.Model;

import java.io.Serializable;

/**
 * Game class
 */
public class Game implements Serializable {

//    private final int TWO_HUNDRED = 200;
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

    /**
     * Gets the current planet type
     *
     * @return current planet type
     */
    public String getCurrentPlanetType() {
        return currentPlanet.getType();
    }

    /**
     * Gets planet fuel price
     *
     * @return current planet fuel price
     */
    public int planetFuelPrice() {
        return currentPlanet.fuelPrice();
    }

    /**
     * Gets amount of fuel player has
     *
     * @return amount of fuel player has
     */
    public int myShipFuel() {
        return player.getShipFuel();
    }

    /**
     * Goods produced on the current planet
     *
     * @return the goods produced on the planet player is on
     */
    public String currentPlanetGoodsProduced() {
        return currentPlanet.goodsProduced();
    }

    /**
     * Gets goods used on planet player is on
     *
     * @return goods used on planet player is on
     */
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
        final int TWO_HUNDRED = 200;
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
                        if (!(player.getCredits() <= 100)) {
                            player.changeCredits(-100);
                        } else {
                            player.setCredits(0);
                        }
                    } else {
                        randomEvent = Events.NO_EVENT;
                    }
                }
                if (randomEvent == Events.GAIN_CREDIT) {
                    if (player.isGoodTrader()) {
                        player.changeCredits(TWO_HUNDRED);
                    } else {
                        player.changeCredits(100);
                    }
                }
            } else {
                randomEvent = Events.NO_EVENT;
            }
            int distance = currentPlanet.calculateDistance(p);
            player.updateShipFuel(fuelCostForPlanet(p));
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
        if (player.isGoodPilot()) {
            return distance / 6;
        } else {
            return distance / 2;
        }
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

    /**
     * Gets a random event
     *
     * @return a random event
     */
    public Events getRandomEvent() {
        return this.randomEvent;
    }
}