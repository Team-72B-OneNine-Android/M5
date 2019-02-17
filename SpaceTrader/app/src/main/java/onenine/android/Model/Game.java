package onenine.android.Model;

public class Game {

    private GameDifficulty difficulty;

    public Game(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameDifficulty getDifficulty() {
        return this.difficulty;
    }

//    public void setDifficulty(GameDifficulty diff) {
//        this.difficulty = diff;
//    }
}
