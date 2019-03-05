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

public class SpaceStationActivity extends AppCompatActivity {

    private SpaceStationActivityViewModel vm;
    private int fuel;
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





    }

    public void onPlanet0Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet0);
        updateCurrentPlanet(0);
    }

    public void onPlanet1Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet1);
        updateCurrentPlanet(1);
    }

    public void onPlanet2Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet2);
        updateCurrentPlanet(2);
    }

    public void onPlanet3Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet3);
        updateCurrentPlanet(3);
    }

    public void onPlanet4Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet4);
        updateCurrentPlanet(4);
    }

    public void onPlanet5Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet5);
        updateCurrentPlanet(5);
    }

    public void onPlanet6Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet6);
        updateCurrentPlanet(6);
    }

    public void onPlanet7Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet7);
        updateCurrentPlanet(7);
    }

    public void onPlanet8Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet8);
        updateCurrentPlanet(8);
    }

    public void onPlanet9Pressed(View view) {
        vm.getGame().setCurrentPlanet(planet9);
        updateCurrentPlanet(9);
    }

    public void updateCurrentPlanet(int i) {
        currentPlanet.setText("You are now on planet " + vm.getUniverse().getPlanet(i).getType());
    }

}
