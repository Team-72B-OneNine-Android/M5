package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import onenine.android.R;
import onenine.android.ViewModel.HomeScreenActivityViewModel;
import android.view.View;

public class HomeScreenActivity extends AppCompatActivity {

    private HomeScreenActivityViewModel vm;
    TextView currentPlanet;
    TextView currentPlayer;

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
        currentPlanet.setText("You are currently on Planet " + vm.getGame().getCurrentPlanet().getType());

    }

    public void onMarketButtonPressed(View view) {
        Intent market = new Intent(this, MarketPlaceActivity.class);
        startActivity(market);
    }
}
