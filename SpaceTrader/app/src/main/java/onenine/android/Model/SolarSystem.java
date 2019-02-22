package onenine.android.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SolarSystem {

    PlanetAttributes pa = new PlanetAttributes();
    List<String> planetsList = Arrays.asList(pa.getPlanetsStringArray());
    List<String> techLevelList = Arrays.asList(pa.getTechLevelStringArray());
    List<String> resourceList = Arrays.asList(pa.getResourcesStringArray());
    List<Planet> planets  = new ArrayList<>();
    Random rand = new Random();


    public void initializeAmountOfPlanets() {
        for (int i = 0; i < 10; i++) {
            planets.add(null);
        }
    }
    public List<Planet> generatePlanets() {
        initializeAmountOfPlanets();
        while (!planets.contains(null)) {
            for(Planet values : planets) {
                int x = getRandomX();
                int y = getRandomY();
                String tempCoordinates = Integer.toString(x) + Integer.toString(y);
                if (!planets.contains(values.getType()) && !tempCoordinates.equals(values.getCoordinateString())) {
                    planets.add(new Planet(getRandomPlanet(), getRandomTechLevel(), getRandomResource(), getRandomX(), getRandomY()));
                }
            }
        }
        return planets;
    }

    public String getRandomPlanet() {
        return planetsList.get(rand.nextInt(planetsList.size()));
    }

    public String getRandomTechLevel() {
        return techLevelList.get(rand.nextInt(techLevelList.size()));
    }

    public String getRandomResource() {
        return resourceList.get(rand.nextInt(resourceList.size()));
    }

    public int getRandomX() {
        return rand.nextInt(149) + 1;
    }

    public int getRandomY() {
        return rand.nextInt(99) + 1;
    }




}
