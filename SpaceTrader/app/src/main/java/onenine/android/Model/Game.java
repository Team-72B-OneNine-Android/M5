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

    public String toString() {
        return player.toString() + "\n" + "Game Difficulty: " + difficulty.toString();
    }

    public boolean travel(Planet p) {
        if (this.fuelCostForPlanet(p) != 0) {
            randomEvent = Events.checkForEvent();
            if (randomEvent == Events.LOSE_CARGO) {
                player.lossOfCargo();
            }
            if (randomEvent == Events.LOSE_CREDIT) {
                if (!(player.getCredits() <= 0)) {
                    player.changeCredits(-100);
                }
            }
            if (randomEvent == Events.GAIN_CREDIT) {
                player.changeCredits(100);
            }
        } else {
            randomEvent = Events.NO_EVENT;
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
//        if (player.getShipFuel() >= fuelCostForPlanet(p)) {
//            randomEvent = Events.checkForEvent();
//            this.setCurrentPlanet(p);
//            int distance = currentPlanet.calculateDistance(p);
//            player.updateShipFuel(distance);
//            if (randomEvent == Events.LOSE_CARGO) {
//                player.lossOfCargo();
//                return true;
//            }
//            if (randomEvent == Events.LOSE_CREDIT) {
//                if (!(player.getCredits() <= 0)) {
//                    player.changeCredits(-100);
//                }
//                return true;
//            }
//            if (randomEvent == Events.GAIN_CREDIT) {
//                player.changeCredits(100);
//                return true;
//            }
//        } else {
//            randomEvent = Events.NO_EVENT;
//            return true;
//        }
//        return false;
//    }

    public int fuelCostForPlanet(Planet planet) {
        int distance = Universe.distanceBetweenTwoPlanets(currentPlanet, planet);
        return distance / 2;
    }

    public String showEventMessage() {
        return Events.getEventMessage(randomEvent);
    }
}
