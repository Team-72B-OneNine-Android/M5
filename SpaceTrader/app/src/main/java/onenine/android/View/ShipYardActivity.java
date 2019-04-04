package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import onenine.android.R;
import onenine.android.ViewModel.ShipYardViewModel;

/**
 * Creates the view for the ship yard
 */
public class ShipYardActivity extends AppCompatActivity {

    private ShipYardViewModel vm;

    /**
     * Creates view for shipyard
     *
     * @param savedInstanceState the saved instance state of game
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_yard);
        vm = ViewModelProviders.of(this).get(ShipYardViewModel.class);
        TextView fp = findViewById(R.id.fuelPrice);
        fp.setText("The current fuel price on " + vm.planetName() + " is: " + String.valueOf(vm.planetFuelPrice()) + " credits/unit");
    }

    /**
     * Switches view back to the home screen activity
     *
     * @param view the view
     */
    public void onBackPressed(View view) {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }

    /**
     * Refuels the player's ship if player has enough credits to do so
     *
     * @param view the view
     */
    public void onRefuelPressed(View view) {
        vm.chargeForFuel(-vm.fuelCost());
        vm.changeFuel(100);
        Toast.makeText(this, "Your Ship has been refueled!", Toast.LENGTH_LONG).show();
    }
}
