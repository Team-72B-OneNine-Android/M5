package onenine.android.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Universe implements Serializable {

    private final List<Planet> planets = new ArrayList<>();

    /**
     * Universe constructor
     */
    public Universe() {
        SolarSystem solarSystem = new SolarSystem();
        solarSystem.generatePlanets(planets);
    }

    /**
     * Gets a specific planet that is in the universe
     *
     * @param i the planet number to get
     * @return a specific planet in a solar system
     */
    public Planet getPlanet(int i) {
        return planets.get(i);
    }

    /**
     * Calulates the distance between two planets in the univers
     *
     * @param source the first planet
     * @param destination the second planet
     * @return the distance between the two planets
     */
    public static int distanceBetweenTwoPlanets(Planet source, Planet destination) {
        return source.calculateDistance(destination);
    }

    /**
     * Displays the universe information
     *
     * @return the information about the universe
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < planets.size(); i++){
            result += (i + 1) + ". ";
            result += planets.get(i).toString();
            result += "\n";
        }
        return result;
    }


}
