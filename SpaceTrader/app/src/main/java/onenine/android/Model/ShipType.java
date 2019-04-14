package onenine.android.Model;

/**
 * All possible ship types
 */
public enum ShipType {
    FLEA(12),
    GNAT(15),
    FIREFLY(20),
    MOSQUITO(15),
    BUMBLEBEE(20),
    BEETLE(50),
    HORNET(20),
    GRASSHOPPER(30),
    TERMITE(60),
    WASP(35);



    private final int cargoSpace;

    /**
     * Ship type constructor that sets the amount of cargo space
     *
     * @param cargoSpace the amount of cargo space for a given shipType
     */
    ShipType(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    /**
     * Gets amount of cargo space a ship has
     *
     * @return the amount of cargo space for a ship
     */
    public int getCargoSpace() {
        return cargoSpace;
    }
}

