package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import onenine.android.R;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void newButton(View view) {
        Intent newGame = new Intent(this, ConfigurationActivity.class);
        startActivity(newGame);
    }

    public void loadGame(View view) {
    }
}
