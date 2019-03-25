package onenine.android.Model;

import java.io.Serializable;

public class Game implements Serializable {

    private GameDifficulty difficulty;
    private Player player;
    private Planet currentPlanet;
    private Events randomEvent;


    public Game(Player p, GameDifficulty difficulty) {
        this.player = p;
        this.difficulty = difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameDifficulty getDifficulty() {
        return this.difficulty;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    @Override
    public String toString() {
        return player.toString() + "\n" + "Game Difficulty: " + difficulty.toString();
    }

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