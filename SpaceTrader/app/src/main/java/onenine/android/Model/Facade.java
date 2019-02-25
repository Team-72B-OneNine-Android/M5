package onenine.android.Model;


import onenine.android.ViewModel.ConfigurationActivityViewModel;

import android.util.Log;


public class Facade {


    private Game game;
    private Player player;
    private Universe universe;

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
        universe = new Universe();
        game.setCurrentPlanet(universe.getPlanet(0));
        Log.d("Game", "Game Information" + "\n" + game.toString());
        Log.d("Universe Information", "Universe Info" + "\n" + universe.toString());
    }
    public Universe getUniverse() {
        return universe;
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
