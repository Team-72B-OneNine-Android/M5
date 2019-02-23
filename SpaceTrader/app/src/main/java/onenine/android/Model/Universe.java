package onenine.android.Model;

import java.util.ArrayList;
import java.util.List;

public class Universe {

    SolarSystem solarSystem = new SolarSystem();
    List<Planet> planets = new ArrayList<>();

    public Universe() {
        solarSystem.generatePlanets(planets);
    }

    public Planet getPlanet(int i) {
        return planets.get(i);
    }

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
