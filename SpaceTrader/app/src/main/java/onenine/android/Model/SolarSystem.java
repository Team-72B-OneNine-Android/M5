package onenine.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Solar system class
 */
public class SolarSystem implements Serializable {

    private final PlanetAttributes pa = new PlanetAttributes();
    private final List<String> planetsList = Arrays.asList(pa.getPlanetsStringArray());
    private final List<String> resourceList = Arrays.asList(pa.getResourcesStringArray());
    private Random rand = new Random();
    private static final int X_COORDINATE = 149;
    private static final int Y_COORDINATE = 99;

    /**
     * Generates 10 random planets for a solar system
     * given a large collection of planets
     *
     * @param planets a large collection of planets
     */
    public void generatePlanets(Collection<Planet> planets) {
//        boolean flag = false;
        if (planets == null) {
            throw new IllegalArgumentException("List of planets cannot be null.");
        }
        if (planets.size() != 0) {
            throw new IllegalArgumentException("Planet list must be empty or have size of zero");
        }
        Collection<String> planetNames = new ArrayList<>();
        Collection<String> coordinateStrings = new ArrayList<>();
        int counter = 0;
        while (counter < 10) {
            int x = getRandomX();
            int y = getRandomY();
            String randomPlanet = getRandomPlanet();
            String tempCoordinates = Integer.toString(x) + Integer.toString(y);
            if (!planetNames.contains(randomPlanet) &&
                    !coordinateStrings.contains(tempCoordinates)) {
                planets.add(new Planet(randomPlanet, getRandomTechLevel(), getRandomResource(),
                        getRandomX(), getRandomY()));
                planetNames.add(randomPlanet);
                coordinateStrings.add(tempCoordinates);
                counter += 1;
            }
//            else {
//                flag = true;
//            }
        }
//        return flag;

    }

    /**
     * Gets a random planet from a list of planets
     *
     * @return random planet as a string
     */
    private String getRandomPlanet() {
        return planetsList.get(rand.nextInt(planetsList.size()));
    }

    /**
     * Gets a random tech level number
     *
     * @return random tech level number
     */
    private TechLevel getRandomTechLevel() {
        int randomTechLevel = new Random().nextInt(TechLevel.values().length);
        return TechLevel.values()[randomTechLevel];
    }

    /**
     * Gets a random resource from a resource list
     *
     * @return a random resource
     */
    private String getRandomResource() {
        return resourceList.get(rand.nextInt(resourceList.size()));
    }

    /**
     * Gets a random x coordinate
     *
     * @return a random x coordinate
     */
    private int getRandomX() {
        return rand.nextInt(X_COORDINATE) + 1;
    }

    /**
     * Gets a random y coordinate
     *
     * @return a random y coordinate
     */
    private int getRandomY() {
        return rand.nextInt(Y_COORDINATE) + 1;
    }

    /**
     * For testing purposes only
     *
     * @return instance of random
     */
    public Random getRand() {
        return rand;
    }

    /**
     * For testing purposes only
     *
     * @param rand instance of Random
     */
    public void setRand(Random rand) {
        this.rand = rand;
    }
}
