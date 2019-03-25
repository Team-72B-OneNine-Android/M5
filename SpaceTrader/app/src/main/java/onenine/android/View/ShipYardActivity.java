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

public class ShipYardActivity extends AppCompatActivity {

    private ShipYardViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_yard);
        vm = ViewModelProviders.of(this).get(ShipYardViewModel.class);
        TextView fp = findViewById(R.id.fuelPrice);
        fp.setText("The current fuel price on " + vm.planetName() + " is: " + String.valueOf(vm.planetFuelPrice()) + " credits/unit");
    }

    public void onBackPressed(View view) {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }

    public void onRefuelPressed(View view) {
        vm.getPlayer().changeCredits(-vm.fuelCost());
        vm.getShip().setShipFuel(100);
        Toast.makeText(this, "Your Ship has been refueled!", Toast.LENGTH_LONG).show();
    }
}
