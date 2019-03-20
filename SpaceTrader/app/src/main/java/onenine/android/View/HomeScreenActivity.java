package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import onenine.android.Model.Facade;
import onenine.android.R;
import onenine.android.ViewModel.HomeScreenActivityViewModel;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class HomeScreenActivity extends AppCompatActivity {

    private HomeScreenActivityViewModel vm;
    TextView currentPlayer;
    TextView currentPlanet;
    TextView currentTechLevel;
    TextView currentResourceType;
    TextView currentLocation;
    TextView currentShip;
    TextView currentFuel;
    TextView currentCargo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //link vm to home screen view model
        vm = ViewModelProviders.of(this).get(HomeScreenActivityViewModel.class);

        //get current player
        currentPlayer = findViewById(R.id.welcomeUser);
        currentPlayer.setText("Hello, " + vm.getGame().getPlayer().getName() + "!");

        //get current planet
        currentPlanet = findViewById(R.id.youAreOn);
        currentPlanet.setText("You are currently on planet " + vm.getGame().getCurrentPlanet().getType());

        //gets coordinates that player is currently at in universe
        currentTechLevel = findViewById(R.id.currentTechLevel);
        currentTechLevel.setText("Tech Level: " + vm.getGame().getCurrentPlanet().getTechLevel().toString());

        //gets coordinates that player is currently at in universe
        currentResourceType = findViewById(R.id.currentResourceType);
        currentResourceType.setText("Resource Type: " + vm.getGame().getCurrentPlanet().getResources());

        //gets coordinates that player is currently at in universe
        currentLocation = findViewById(R.id.currentLocation);
        currentLocation.setText("Current Location in Universe: " + vm.getGame().getCurrentPlanet().coordinatesPretty());

        //gets player ship type
        currentShip = findViewById(R.id.currentShip);
        currentShip.setText("Current Ship Type: " + vm.getGame().getPlayer().getShip().getShipType().toString());

        //gets amount of fuel that player has left
        currentFuel = findViewById(R.id.currentFuel);
        currentFuel.setText("Fuel Remaining: " + Integer.toString(vm.getGame().getPlayer().getShip().getShipFuel()) + "%");

        //gets current cargo that player has in ship
        currentCargo = findViewById(R.id.currentCargo);
        currentCargo.setText("Current Cargo in Ship: " + vm.getGame().getPlayer().getShip().currentGoods());

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
        }
    }

    public void onShipYardButtonPressed(View view) {
        Intent shipYard = new Intent(this, ShipYardActivity.class);
        startActivity(shipYard);
    }
}
