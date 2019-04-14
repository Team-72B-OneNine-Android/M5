package onenine.android.Model;


import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/**
 * Application Facade
 */
public final class Facade {

    public static final String DEFAULT_BINARY_FILE_NAME = "myGame.bin";
    private Game game;
    private Player player;
    private Universe universe;

    private static final Facade instance = new Facade();

    /**
     * Gets the instance of the facade
     *
     * @return instance of Facade
     */
    public static Facade getInstance() { return instance; }

    /**
     * Facade constructor
     */
    private Facade() {

    }

    /**
     * creates the player with
     * all appropriate player information
     *
     * @param name the player's name
     * @param p the player's pilot points
     * @param f the player's fighter points
     * @param t the player's trader points
     * @param e the player's engineer points
     * @param credits the player's credits
     */
    public void setPlayer(String name, int p, int f, int t, int e, int credits) {
        player = new Player(name, p, f, t, e, credits);
    }

    /**
     * Creates the game and sets the game difficulty
     *
     * @param difficulty the game difficulty
     */
    public void setGame(GameDifficulty difficulty) {
        game = new Game(player, difficulty);
        universe = new Universe();
        game.setCurrentPlanet(universe.getPlanet(0));
        Log.d("Game", "Game Information" + "\n" + game.toString());
        Log.d("Universe Information", "Universe Info" + "\n" + universe.toString());
    }


    /**
     * Gets the player's name
     *
     * @return the player's name as a string
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Gets a specific planet in the universe
     *
     * @param i the planet to get in the universe
     * @return a specific planet in the universe
     */
    public Planet getPlanet(int i) {
        return universe.getPlanet(i);
    }

    /**
     * Gets the game's current player
     *
     * @return the game's current player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the amount of credits the player has
     *
     * @return the player's credits
     */
    public int getPlayerCredits() {
        return this.player.getCredits();
    }

    /**
     * Gets the ship type of the player's ship
     *
     * @return player's ship type
     */
    public ShipType shipType() {
        return player.myShipType();
    }

    /**
     * Gets the amount of fuel the player has
     *
     * @return the amount of fuel the player has for ship
     */
    public int myShipFuel() {
        return player.getShipFuel();
    }

    /**
     * Gets the player's ship cargo space
     *
     * @return player's cargo space
     */
    public int cargoSpace() {
        return player.getShipCargoSpace();
    }

    /**
     * Gets the goods that are currently on player's ship
     *
     * @return player's goods
     */
    public String shipCurrentGoods() {
        return player.myCurrentGoods();
    }

    /**
     * Gets the goods produced on the planet the player is on
     *
     * @return goods produced the player is on
     */
    public String planetGoodsProduced() {
        return game.currentPlanetGoodsProduced();
    }

    /**
     * Gets the goods used on the planet the player is on
     *
     * @return the goods used on the planet the player is on
     */
    public String planetGoodsUsed() {
        return game.currentPlanetGoodsUsed();
    }

    /**
     * Changes the amount of credits a player has
     *
     * @param i the amount of credits to set for the player
     */
    public void changeMyCredits(int i) {
        player.changeCredits(i);
    }

    /**
     * Changes the amount of fuel the ship has
     *
     * @param i amount of fuel to set the player's ship to have
     */
    public void changeShipFuel(int i) {
        player.changeMyFuel(i);
    }

    /**
     * Gets the planet the player is currently on
     *
     * @return the planet the player is currently on
     */
    public Planet getCurrentPlanet() {
        return game.getCurrentPlanet();
    }

    /**
     * Gets the planet type of the planet the player is on
     *
     * @return the planet type the player is on
     */
    public String getPlanetType() {
        return game.getCurrentPlanetType();
    }

    /**
     * Gets the fuel price for the planet the player is on
     *
     * @return the price for fuel for the planet the player is on
     */
    public int getCurrentPlanetFuelPrice() {
        return game.planetFuelPrice();
    }

    /**
     * Gets the instance of the current game
     *
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Determines whether player is a good trader
     *
     * @return whether player is a good trader
     */
    public boolean goodTrader() {
        return this.player.isGoodTrader();
    }

    /**
     * Saves the binary for the current game
     *
     * @param file the binary file for the game
     * @return boolean whether or not the
     * game saved successfully
     */
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

    /**
     * Loads the saved binary file to load a previously saved game
     *
     * @param file the saved binary file
     * @return boolean whether the saved binary file
     * was loaded successfully
     */
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
