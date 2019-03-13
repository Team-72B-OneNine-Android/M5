package onenine.android.Model;

import java.util.Random;

public class Game {

    private GameDifficulty difficulty;
    private Player player;
    private Planet currentPlanet;


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

    public String toString() {
        return player.toString() + "\n" + "Game Difficulty: " + difficulty.toString();
    }

    public boolean travel(Planet p) {
        if (this.fuelCostForPlanet(p) != 0) {
            if (checkForEvent() == Events.LOSE_CARGO) {
                player.lossOfCargo();
            }
            if (checkForEvent() == Events.LOSE_CREDIT) {
                player.changeCredits(-100);
            }
            if (checkForEvent() == Events.GAIN_CREDIT) {
                player.changeCredits(100);
            }
        }
        int distance = currentPlanet.calculateDistance(p);
        int fuel = player.updateShipFuel(distance);
        if (fuel >= 0) {
            this.setCurrentPlanet(p);
            return true;
        } else {
            return false;
        }
    }

    public int fuelCostForPlanet(Planet planet) {
        int distance = Universe.distanceBetweenTwoPlanets(currentPlanet, planet);
        return distance / 2;
    }

    public Events checkForEvent() {
        int random = new Random().nextInt(100);
        Events[] possibleEvents = Events.values();
        int randomEvent = new Random().nextInt(possibleEvents.length - 2);
        randomEvent += 1;
        if (random > 60) {
            return possibleEvents[randomEvent];
        } else {
            return possibleEvents[0];
        }
    }
}
