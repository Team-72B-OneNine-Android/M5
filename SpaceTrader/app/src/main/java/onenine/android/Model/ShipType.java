package onenine.android.Model;

public enum ShipType {
    GNAT(15);


    private final int cargoSpace;

    ShipType(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }
}

