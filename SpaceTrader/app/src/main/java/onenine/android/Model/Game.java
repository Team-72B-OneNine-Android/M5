package onenine.android.Model;

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
}
