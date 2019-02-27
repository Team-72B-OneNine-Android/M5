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
    Button marketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ConfigurationActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.welcomeUser);
        textView.setText("Welcome " + message + "!");

        vm = ViewModelProviders.of(this).get(HomeScreenActivityViewModel.class);
        currentPlanet = findViewById(R.id.currentPlanet);
        updateCurrentPlanet();

    }
    public void updateCurrentPlanet() {
        currentPlanet.setText(vm.getGame().getCurrentPlanet().getType());
    }

    public void onMarketButtonPressed(View view) {
        Intent market = new Intent(this, MarketPlaceActivity.class);
        startActivity(market);
    }
}
