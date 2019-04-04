package onenine.android.Model;
import java.util.Random;

public enum Goods {
    WATER("Water", 0, 0, 2, 30, 3, 4, IE.DROUGHT, CR.LOTSOFWATER, ER.DESERT),
    FURS("Furs", 0, 0, 0, 250, 10, 10, IE.COLD, CR.RICHFAUNA, ER.LIFELESS),
    FOOD("Food", 1, 0, 1, 100, 5, 5, IE.CROPFAIL, CR.RICHSOIL, ER.POORSOIL),
    ORE("Ore", 2, 2, 3, 350, 20, 10, IE.WAR, CR.MINERALRICH, ER.MINERALPOOR),
    GAMES("Games", 3, 1, 6, 250, -10, 5, IE.BOREDOM, CR.ARTISTIC, ER.NEVER),
    FIREARMS("Firearms", 3, 1, 5, 1250, -75, 100, IE.WAR, CR.WARLIKE, ER.NEVER),
    MEDICINE("Medicine", 4, 1, 6, 650, -20, 10, IE.PLAGUE, CR.LOTSOFHERBS, ER.NEVER),
    MACHINES("Machines", 4, 3, 5, 900, -30, 5, IE.LACKOFWORKERS, CR.NEVER, ER.NEVER),
    NARCOTICS("Narcotics", 5, 0, 5, 3500, -125, 150, IE.BOREDOM, CR.WEIRDMUSHROOMS, ER.NEVER),
    ROBOTS("Robots", 6, 4, 7, 5000, -150, 100, IE.LACKOFWORKERS, CR.NEVER, ER.NEVER);


    private final String name;
    private final int MTLP;
    private final int MTLU;
    private final int basePrice;
    private final int IPL;
    private final int var;
    private Planet current;
    private int price;
    private final Facade gameFacade = Facade.getInstance();
    private static final double TRADER_DISCOUNT = 0.20;

    /**
     * Goods constructor
     *
     * @param name the good name
     * @param MTLP the good MTLP
     * @param MTLU the good MTLU
     * @param TTP the good TTP
     * @param basePrice the good base price
     * @param IPL the good IPL
     * @param var the good var
     * @param increasePrice the good price increase
     * @param cheapResource the good cheap resource
     * @param expensiveResource the good expensive resource
     */
    Goods(String name, int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
          IE increasePrice, CR cheapResource, ER expensiveResource) {
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.var = var;
    }

    /**
     * Gets the current planet of the game facade
     *
     * @return the game facade's current planet
     */
    private Planet currentPlanet() {
        return gameFacade.getCurrentPlanet();
    }

    private boolean playerGoodTrader() {
        return gameFacade.goodTrader();
    }

    /**
     * Gets the current planets tech level number
     *
     * @return the number that represents the
     * current planets tech level
     */
    private int getCurrentPlanetTechLevel() {
        return currentPlanet().getTechLevelNum();
    }

    /**
     * Determines whether or not a good can be bought
     *
     * @return whether the good can be bought on
     * the current planet
     */
    public boolean canBuy() {
        return getCurrentPlanetTechLevel() >= this.MTLP;
    }

    /**
     * Determines whether good can be sold
     *
     * @return whether good can be sold
     */
    public boolean canSell() {
        return getCurrentPlanetTechLevel() >= this.MTLU;
    }

    /**
     * Calculates the var for a specific good
     *
     * @return the var of the specific good
     */
    private double calculateVar() {
        double randVar = new Random().nextInt(this.var);
        return randVar/100;
    }

    /**
     * Determines the price of a good
     *
     * @return the price of a good
     */
    public int getPrice() {
        int currentPrice = this.basePrice + (this.IPL * (getCurrentPlanetTechLevel() - this.MTLP));
        if (current == null) {
            current = currentPlanet();
            this.price = ((int) (currentPrice + (this.basePrice * calculateVar())));
            if (playerGoodTrader()) {
                return ((int) (this.price - (TRADER_DISCOUNT * this.price)));
            }
            return price;
        } else if (current.equals(currentPlanet())) {
            if (playerGoodTrader()) {
                return ((int) (this.price - (TRADER_DISCOUNT * this.price)));
            }
            return price;
        } else {
            current = currentPlanet();
            this.price = (int) (currentPrice + (this.basePrice * calculateVar()));
            if (playerGoodTrader()) {
                return ((int) (this.price - (TRADER_DISCOUNT * this.price)));
            }
            return price;
        }
    }

    /**
     * Gets buying price of a good as a string
     *
     * @return the good price as a string
     */
    public String buyStringPrice() {
        if (canBuy()) {
            return String.valueOf(getPrice());
        } else {
            return "N/P";
        }
    }

    /**
     * Gets the sell price of a good as a string
     *
     * @return the sell price of a good as a string
     */
    public String sellStringPrice() {
        if (canSell()) {
            return String.valueOf(getPrice());
        } else {
            return "N/U";
        }
    }

    /**
     * Gets the name of a godd
     *
     * @return the name of a good as a string
     */
    public String getName() {
        return this.name;
    }
}
