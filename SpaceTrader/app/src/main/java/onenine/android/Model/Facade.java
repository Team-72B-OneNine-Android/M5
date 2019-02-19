package onenine.android.Model;

import android.util.Log;

public class Facade {


    private Game game;
    private Player player;


    private static  Facade instance = new Facade();

    public static Facade getInstance() { return instance; }


    private Facade() {

    }

    public void setPlayer(String name, int f, int p, int t, int e) {
        player = new Player(name, f, p, t, e);
        Log.d("Player", "Player Information" + "\n" + player.toString());
    }

    public void setGame(GameDifficulty difficulty) {
        game = new Game(player, difficulty);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Game getGame() {
        return this.game;
    }
}
