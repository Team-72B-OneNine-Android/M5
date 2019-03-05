package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import onenine.android.Model.Planet;
import onenine.android.R;
import onenine.android.ViewModel.SpaceStationActivityViewModel;
import android.view.View;
import android.widget.Toast;

public class SpaceStationActivity extends AppCompatActivity {

    private SpaceStationActivityViewModel vm;
    private Planet planet0;
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;
    private Planet planet4;
    private Planet planet5;
    private Planet planet6;
    private Planet planet7;
    private Planet planet8;
    private Planet planet9;
    TextView currentPlanet;
    TextView currentFuel;
    TextView fuelCost0;
    TextView fuelCost1;
    TextView fuelCost2;
    TextView fuelCost3;
    TextView fuelCost4;
    TextView fuelCost5;
    TextView fuelCost6;
    TextView fuelCost7;
    TextView fuelCost8;
    TextView fuelCost9;
    Button planet0B;
    Button planet1B;
    Button planet2B;
    Button planet3B;
    Button planet4B;
    Button planet5B;
    Button planet6B;
    Button planet7B;
    Button planet8B;
    Button planet9B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_station);

        //initialize view model
        vm = ViewModelProviders.of(this).get(SpaceStationActivityViewModel.class);

        //Get planet and fuel design ids
        currentPlanet = findViewById(R.id.spaceStationPlanet);
        currentFuel = findViewById(R.id.spaceStationFuel);

        //get current planet
        currentPlanet = findViewById(R.id.spaceStationPlanet);
        currentPlanet.setText("You are currently on planet " + vm.getGame().getCurrentPlanet().getType());

        //gets amount of fuel that player has left
        currentFuel = findViewById(R.id.spaceStationFuel);
        currentFuel.setText("Fuel Remaining: " + Integer.toString(vm.getGame().getPlayer().getShip().getShipFuel()) + "%");

        //Planet Buttons
        planet0B = findViewById(R.id.planet0);
        planet1B = findViewById(R.id.planet1);
        planet2B = findViewById(R.id.planet2);
        planet3B = findViewById(R.id.planet3);
        planet4B = findViewById(R.id.planet4);
        planet5B = findViewById(R.id.planet5);
        planet6B = findViewById(R.id.planet6);
        planet7B = findViewById(R.id.planet7);
        planet8B = findViewById(R.id.planet8);
        planet9B = findViewById(R.id.planet9);

        //Set text of each button
        planet0B.setText(vm.getUniverse().getPlanet(0).getType());
        planet1B.setText(vm.getUniverse().getPlanet(1).getType());
        planet2B.setText(vm.getUniverse().getPlanet(2).getType());
        planet3B.setText(vm.getUniverse().getPlanet(3).getType());
        planet4B.setText(vm.getUniverse().getPlanet(4).getType());
        planet5B.setText(vm.getUniverse().getPlanet(5).getType());
        planet6B.setText(vm.getUniverse().getPlanet(6).getType());
        planet7B.setText(vm.getUniverse().getPlanet(7).getType());
        planet8B.setText(vm.getUniverse().getPlanet(8).getType());
        planet9B.setText(vm.getUniverse().getPlanet(9).getType());

        //Declare planet values
        planet0 = vm.getUniverse().getPlanet(0);
        planet1 = vm.getUniverse().getPlanet(1);
        planet2 = vm.getUniverse().getPlanet(2);
        planet3 = vm.getUniverse().getPlanet(3);
        planet4 = vm.getUniverse().getPlanet(4);
        planet5 = vm.getUniverse().getPlanet(5);
        planet6 = vm.getUniverse().getPlanet(6);
        planet7 = vm.getUniverse().getPlanet(7);
        planet8 = vm.getUniverse().getPlanet(8);
        planet9 = vm.getUniverse().getPlanet(9);

        //get fuel cost ids
        fuelCost0 = findViewById(R.id.fuelCost0);
        fuelCost1 = findViewById(R.id.fuelCost1);
        fuelCost2 = findViewById(R.id.fuelCost2);
        fuelCost3 = findViewById(R.id.fuelCost3);
        fuelCost4 = findViewById(R.id.fuelCost4);
        fuelCost5 = findViewById(R.id.fuelCost5);
        fuelCost6 = findViewById(R.id.fuelCost6);
        fuelCost7 = findViewById(R.id.fuelCost7);
        fuelCost8 = findViewById(R.id.fuelCost8);
        fuelCost9 = findViewById(R.id.fuelCost9);

        //Set fuel cost text
        fuelCost0.setText("Cost: " + Integer.toString(fuelCostForPlanet(0)) + "%");
        fuelCost1.setText("Cost: " + Integer.toString(fuelCostForPlanet(1)) + "%");
        fuelCost2.setText("Cost: " + Integer.toString(fuelCostForPlanet(2)) + "%");
        fuelCost3.setText("Cost: " + Integer.toString(fuelCostForPlanet(3)) + "%");
        fuelCost4.setText("Cost: " + Integer.toString(fuelCostForPlanet(4)) + "%");
        fuelCost5.setText("Cost: " + Integer.toString(fuelCostForPlanet(5)) + "%");
        fuelCost6.setText("Cost: " + Integer.toString(fuelCostForPlanet(6)) + "%");
        fuelCost7.setText("Cost: " + Integer.toString(fuelCostForPlanet(7)) + "%");
        fuelCost8.setText("Cost: " + Integer.toString(fuelCostForPlanet(8)) + "%");
        fuelCost9.setText("Cost: " + Integer.toString(fuelCostForPlanet(9)) + "%");





    }

    public void onPlanet0Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet0));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet0);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet1Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet1));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet1);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet2Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet2));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet2);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet3Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet3));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet3);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet4Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet4));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet4);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet5Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet5));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet5);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet6Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet6));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet6);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet7Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet7));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet7);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet8Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet8));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet8);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    public void onPlanet9Pressed(View view) {
        int result = decreaseFuel(calculateDistance(vm.getGame().getCurrentPlanet(), planet9));
        if (result >= 0) {
            vm.getGame().getPlayer().getShip().setShipFuel(result);
            vm.getGame().setCurrentPlanet(planet9);
            goToHomeScreen();
        } else {
            displayToast();
        }
    }


    public int calculateDistance(Planet planet1, Planet planet2) {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int xDiff = 0;
        int yDiff = 0;
        x1 = planet1.getX();
        x2 = planet2.getX();
        y1 = planet1.getY();
        y2 = planet2.getY();
        xDiff = x2 - x1;
        yDiff = y2 - y1;
        return (int) Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));
    }

    public int decreaseFuel(int distance) {
        int amount = vm.getGame().getPlayer().getShip().getShipFuel();
        int percentDecrease = distance / 2;
        int result = amount - percentDecrease;
        return result;
    }
    public int fuelCostForPlanet(int i) {
        int distance = calculateDistance(vm.getGame().getCurrentPlanet(), vm.getUniverse().getPlanet(i));
        return distance / 2;
    }

    public void goToHomeScreen() {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }

    public void displayToast() {
        Toast notEnoughFuel = Toast.makeText(getApplicationContext(), "Sorry, you do not have enough fuel to "
                + "travel there", Toast.LENGTH_LONG);
        notEnoughFuel.show();
    }

}
