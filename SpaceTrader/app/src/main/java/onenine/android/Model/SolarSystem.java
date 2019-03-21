package onenine.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SolarSystem implements Serializable {

    PlanetAttributes pa = new PlanetAttributes();
    TechLevel techLevel;
    List<String> planetsList = Arrays.asList(pa.getPlanetsStringArray());
    List<String> resourceList = Arrays.asList(pa.getResourcesStringArray());
    Random rand = new Random();
    private static final int X_COORDINATE = 149;
    private static final int Y_COORDINATE = 99;

    public void generatePlanets(List<Planet> planets) {
        List<String> planetNames = new ArrayList<>();
        List<String> coordinateStrings = new ArrayList<>();
        int counter = 0;
        while (counter < 10) {
            int x = getRandomX();
            int y = getRandomY();
            String randomPlanet = getRandomPlanet();
            String tempCoordinates = Integer.toString(x) + Integer.toString(y);
            if (!planetNames.contains(randomPlanet) && !coordinateStrings.contains(tempCoordinates)) {
                planets.add(new Planet(randomPlanet, getRandomTechLevel(), getRandomResource(), getRandomX(), getRandomY()));
                planetNames.add(randomPlanet);
                coordinateStrings.add(tempCoordinates);
                counter += 1;
            }
        }

        }


    public String getRandomPlanet() {
        return planetsList.get(rand.nextInt(planetsList.size()));
    }

    public TechLevel getRandomTechLevel() {
        int randomTechLevel = new Random().nextInt(TechLevel.values().length);
        return TechLevel.values()[randomTechLevel];
    }

    public String getRandomResource() {
        return resourceList.get(rand.nextInt(resourceList.size()));
    }

    public int getRandomX() {
        return rand.nextInt(X_COORDINATE) + 1;
    }

    public int getRandomY() {
        return rand.nextInt(Y_COORDINATE) + 1;
    }




}
