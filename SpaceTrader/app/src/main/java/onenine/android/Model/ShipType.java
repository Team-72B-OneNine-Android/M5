package onenine.android.Model;

public enum ShipType {
    GNAT(15);


    private final int cargoSpace;

    /**
     * Ship type constructor that sets the amount of cargo space
     *
     * @param cargoSpace the amount of cargo space for a given shiptype
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

