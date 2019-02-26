package onenine.android.Model;

public enum ShipType {
    FLEA(10),
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

    ShipType(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }
}

