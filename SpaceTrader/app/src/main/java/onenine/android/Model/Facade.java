package onenine.android.Model;


import onenine.android.ViewModel.ConfigurationActivityViewModel;

import android.util.Log;


public class Facade {


    private Game game;
    private Player player;

    private ConfigurationActivityViewModel vm;



    private static  Facade instance = new Facade();

    public static Facade getInstance() { return instance; }


    private Facade() {

    }

    public void setPlayer(String name, int p, int f, int t, int e, String ship, int credits) {
        player = new Player(name, p, f, t, e, ship, credits);
    }

    public void setGame(GameDifficulty difficulty) {
        game = new Game(player, difficulty);
        Log.d("Game", "Game Information" + "\n" + game.toString());
    }
    public String getPlayerName() {
        return player.getName();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Game getGame() {
        return this.game;
    }
}
