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


    private String name;
    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int var;
    private IE increasePrice;
    private CR cheapResource;
    private ER expensiveResource;
    private Planet current;
    private int price;

    Goods(String name, int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
          IE increasePrice, CR cheapResource, ER expensiveResource) {
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.var = var;
        this.increasePrice = increasePrice;
        this.cheapResource = cheapResource;
        this.expensiveResource = expensiveResource;
    }

    private Planet currentPlanet() {
        return Facade.getInstance().getGame().getCurrentPlanet();
    }

    private int getCurrentPlanetTechLevel() {
        return currentPlanet().getTechLevelNum();
    }

    public boolean canBuy() {
        return getCurrentPlanetTechLevel() >= this.MTLP;
    }

    public boolean canSell() {
        return getCurrentPlanetTechLevel() >= this.MTLU;
    }

    private double calculateVar() {
        double randVar = new Random().nextInt(this.var);
        return randVar/100;
    }

    public int getPrice() {
        int randomEvent = new Random().nextInt(101);
        int currentPrice = this.basePrice + (this.IPL * (getCurrentPlanetTechLevel() - this.MTLP));
        if (current == null) {
            current = currentPlanet();
            this.price = ((int) (currentPrice + (this.basePrice * calculateVar())));
            return price;
        } else if (current.equals(currentPlanet())) {
            return price;
        } else {
            current = currentPlanet();
            if (randomEvent >= 90) {
                this.basePrice = (int) (basePrice * 1.5);
            }
            if (randomEvent <= 10) {
                this.basePrice = (int) (basePrice * 1.35);
            }
            if (randomEvent > 70 && randomEvent < 90) {
                this.basePrice = (int) (basePrice * 0.60);
            }
            this.price = (int) (currentPrice + (this.basePrice * calculateVar()));
            return price;
        }
    }

    public String buyStringPrice() {
        if (canBuy()) {
            return String.valueOf(getPrice());
        } else {
            return "N/P";
        }
    }

    public String sellStringPrice() {
        if (canSell()) {
            return String.valueOf(getPrice());
        } else {
            return "N/U";
        }
    }

    public String getName() {
        return this.name;
    }
}
