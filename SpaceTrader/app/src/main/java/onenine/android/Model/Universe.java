package onenine.android.Model;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    SolarSystem solarSystem = new SolarSystem();
    List<Planet> planets = solarSystem.generatePlanets();

}
