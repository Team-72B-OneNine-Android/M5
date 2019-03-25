package onenine.android.Model;


import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;



public final class Facade {

    public static final String DEFAULT_BINARY_FILE_NAME = "myGame.bin";
    private Game game;
    private Player player;
    private Universe universe;

    private static final Facade instance = new Facade();

    public static Facade getInstance() { return instance; }


    private Facade() {

    }

    public void setPlayer(String name, int p, int f, int t, int e, int credits) {
        player = new Player(name, p, f, t, e, credits);
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

    public Ship getShip() {
        return player.getShip();
    }

    public Planet getCurrentPlanet() {
        return game.getCurrentPlanet();
    }

    public Game getGame() {
        return this.game;
    }

    public boolean saveBinary(File file) {
        boolean success = true;
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(game);
            out.writeObject(player);
            out.writeObject(universe);
            out.close();
        } catch (IOException e) {
            Log.e("Facade", "Error writing an entry from binary file",e);
            success = false;
        }
        return success;
    }

    public boolean loadBinary(File file) {
        boolean success = true;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            game = (Game) in.readObject();
            player = (Player) in.readObject();
            universe = (Universe) in.readObject();
            in.close();
        } catch (IOException e1) {
            Log.e("Facade", "Error reading an entry from binary file",e1);
            success = false;
        } catch (ClassNotFoundException e2) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e2);
            success = false;
        }
        return success;
    }
}
