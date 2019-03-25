package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import onenine.android.Model.Facade;
import onenine.android.Model.Planet;
import onenine.android.R;
import onenine.android.ViewModel.HomeScreenActivityViewModel;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class HomeScreenActivity extends AppCompatActivity {

    private HomeScreenActivityViewModel vm;
    private TextView currentPlayer;
    private TextView currentPlanet;
    private TextView currentTechLevel;
    private TextView currentResourceType;
    private TextView currentLocation;
    private TextView currentShip;
    private TextView currentFuel;
    private TextView currentCargo;
    private Planet planet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //link vm to home screen view model
        vm = ViewModelProviders.of(this).get(HomeScreenActivityViewModel.class);
        planet = vm.getCurrentPlanet();

        //get current player
        currentPlayer = findViewById(R.id.welcomeUser);
        currentPlayer.setText("Hello, " + vm.getPlayerName() + "!");

        //get current planet
        currentPlanet = findViewById(R.id.youAreOn);
        currentPlanet.setText("You are currently on planet " + planet.getType());

        //gets coordinates that player is currently at in universe
        currentTechLevel = findViewById(R.id.currentTechLevel);
        currentTechLevel.setText("Tech Level: " + planet.getTechLevel().toString());

        //gets coordinates that player is currently at in universe
        currentResourceType = findViewById(R.id.currentResourceType);
        currentResourceType.setText("Resource Type: " + planet.getResources());

        //gets coordinates that player is currently at in universe
        currentLocation = findViewById(R.id.currentLocation);
        currentLocation.setText("Current Location in Universe: " + planet.coordinatesPretty());

        //gets player ship type
        currentShip = findViewById(R.id.currentShip);
        currentShip.setText("Current Ship Type: " + vm.getShip().getShipType().toString());

        //gets amount of fuel that player has left
        currentFuel = findViewById(R.id.currentFuel);
        currentFuel.setText("Fuel Remaining: " + Integer.toString(vm.getShip().getShipFuel()) + "%");

        //gets current cargo that player has in ship
        currentCargo = findViewById(R.id.currentCargo);
        currentCargo.setText("Current Cargo in Ship: " + vm.getShip().currentGoods());

    }

    public void onMarketButtonPressed(View view) {
        Intent market = new Intent(this, MarketPlaceActivity.class);
        startActivity(market);
    }

    public void onTravelButtonPressed(View view) {
        Intent spaceStation = new Intent(this, SpaceStationActivity.class);
        startActivity(spaceStation);
    }

    public void onSaveButtonPressed(View view) {
        File file = new File(this.getFilesDir(), Facade.DEFAULT_BINARY_FILE_NAME);
        boolean result = Facade.getInstance().saveBinary(file);
        if (result == false) {
            Toast.makeText(this, "Can't Save!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Game Saved!", Toast.LENGTH_LONG).show();
        }
    }

    public void onShipYardButtonPressed(View view) {
        if (planet.getTechLevelNum() < 2) {
            Toast.makeText(this, "This planet is too small and poor to have a shipyard!", Toast.LENGTH_LONG).show();
        } else {
            Intent shipYard = new Intent(this, ShipYardActivity.class);
            startActivity(shipYard);
        }
    }
}
