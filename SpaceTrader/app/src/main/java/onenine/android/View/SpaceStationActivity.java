package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import onenine.android.Model.Game;
import onenine.android.Model.Planet;
import onenine.android.R;
import onenine.android.ViewModel.SpaceStationActivityViewModel;
import android.view.View;
import android.widget.Toast;

public class SpaceStationActivity extends AppCompatActivity {

    private Game myGame;
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

    /**
     * Creates view for space port
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_station);

        //initialize view model
        SpaceStationActivityViewModel vm = ViewModelProviders.of(this).get(SpaceStationActivityViewModel.class);
        myGame = vm.getGame();

        //get current planet
        TextView currentPlanet = findViewById(R.id.spaceStationPlanet);
        currentPlanet.setText("You are currently on planet " + myGame.getCurrentPlanetType());

        //gets amount of fuel that player has left
        TextView currentFuel = findViewById(R.id.spaceStationFuel);
        currentFuel.setText("Fuel Remaining: " + Integer.toString(myGame.myShipFuel()) + "%");

        //Planet Buttons
        Button planet0B = findViewById(R.id.planet0);
        Button planet1B = findViewById(R.id.planet1);
        Button planet2B = findViewById(R.id.planet2);
        Button planet3B = findViewById(R.id.planet3);
        Button planet4B = findViewById(R.id.planet4);
        Button planet5B = findViewById(R.id.planet5);
        Button planet6B = findViewById(R.id.planet6);
        Button planet7B = findViewById(R.id.planet7);
        Button planet8B = findViewById(R.id.planet8);
        Button planet9B = findViewById(R.id.planet9);

        //Declare planet values
        planet0 = vm.getPlanetAtIndex(0);
        planet1 = vm.getPlanetAtIndex(1);
        planet2 = vm.getPlanetAtIndex(2);
        planet3 = vm.getPlanetAtIndex(3);
        planet4 = vm.getPlanetAtIndex(4);
        planet5 = vm.getPlanetAtIndex(5);
        planet6 = vm.getPlanetAtIndex(6);
        planet7 = vm.getPlanetAtIndex(7);
        planet8 = vm.getPlanetAtIndex(8);
        planet9 = vm.getPlanetAtIndex(9);

        //Set text of each button
        planet0B.setText(planet0.getType());
        planet1B.setText(planet1.getType());
        planet2B.setText(planet2.getType());
        planet3B.setText(planet3.getType());
        planet4B.setText(planet4.getType());
        planet5B.setText(planet5.getType());
        planet6B.setText(planet6.getType());
        planet7B.setText(planet7.getType());
        planet8B.setText(planet8.getType());
        planet9B.setText(planet9.getType());


        //get fuel cost ids
        TextView fuelCost0 = findViewById(R.id.fuelCost0);
        TextView fuelCost1 = findViewById(R.id.fuelCost1);
        TextView fuelCost2 = findViewById(R.id.fuelCost2);
        TextView fuelCost3 = findViewById(R.id.fuelCost3);
        TextView fuelCost4 = findViewById(R.id.fuelCost4);
        TextView fuelCost5 = findViewById(R.id.fuelCost5);
        TextView fuelCost6 = findViewById(R.id.fuelCost6);
        TextView fuelCost7 = findViewById(R.id.fuelCost7);
        TextView fuelCost8 = findViewById(R.id.fuelCost8);
        TextView fuelCost9 = findViewById(R.id.fuelCost9);

        //Set fuel cost text
        fuelCost0.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet0)) + "%");
        fuelCost1.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet1)) + "%");
        fuelCost2.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet2)) + "%");
        fuelCost3.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet3)) + "%");
        fuelCost4.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet4)) + "%");
        fuelCost5.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet5)) + "%");
        fuelCost6.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet6)) + "%");
        fuelCost7.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet7)) + "%");
        fuelCost8.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet8)) + "%");
        fuelCost9.setText("Cost: " + Integer.toString(fuelCostForPlanet(planet9)) + "%");


    }

    /**
     * Checks if the player has enough fuel to travel to the first planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet0Pressed(View view) {
        if (myGame.travel(planet0)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the second planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet1Pressed(View view) {
        if (myGame.travel(planet1)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the third planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet2Pressed(View view) {
        if (myGame.travel(planet2)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the fourth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet3Pressed(View view) {
        if (myGame.travel(planet3)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the fifth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet4Pressed(View view) {
        if (myGame.travel(planet4)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the sixth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet5Pressed(View view) {
        if (myGame.travel(planet5)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the seventh planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet6Pressed(View view) {
        if (myGame.travel(planet6)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the eighth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet7Pressed(View view) {
        if (myGame.travel(planet7)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the ninth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet8Pressed(View view) {
        if (myGame.travel(planet8)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Checks if the player has enough fuel to travel to the tenth planet. If player has enough fuel,
     * then he or she will travel to the selected planet and the view will switch to the home screen activity.
     * If player does not have enough fuel, then nothing will happen.
     *
     * @param view
     */
    public void onPlanet9Pressed(View view) {
        if (myGame.travel(planet9)) {
            displayEventToast();
            goToHomeScreen();
        } else {
            displayToast();
        }
    }

    /**
     * Gets the amount of fuel required to travel to a specific planet
     *
     * @param p a given planet
     * @return the amount of fuel required to travel to a given planet
     */
    private int fuelCostForPlanet(Planet p) {
        return myGame.fuelCostForPlanet(p);
    }

    /**
     * Switches view to home screen activity and takes player to home screen
     */
    private void goToHomeScreen() {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }

    /**
     * Displays a message if the player does not have enough fuel to travel to
     * a planet that he or she selects
     */
    private void displayToast() {
        Toast notEnoughFuel = Toast.makeText(getApplicationContext(), "Sorry, you do not have enough fuel to "
                + "travel there", Toast.LENGTH_LONG);
        notEnoughFuel.show();
    }

    /**
     * Displays message to player when a random event occurs during travel between two planets
     */
    private void displayEventToast() {
        if (myGame.showEventMessage().length() >= 1) {
            Toast eventHappened = Toast.makeText(getApplicationContext(), myGame.showEventMessage(), Toast.LENGTH_LONG);
            eventHappened.show();
        }
    }

}