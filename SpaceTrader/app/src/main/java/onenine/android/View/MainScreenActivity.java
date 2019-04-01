package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import onenine.android.Model.Facade;
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
        File file = new File(this.getFilesDir(), Facade.DEFAULT_BINARY_FILE_NAME);
        boolean result = Facade.getInstance().loadBinary(file);
        if (!result) {
            Toast.makeText(this, "No saved game exist!", Toast.LENGTH_LONG).show();
        } else {
            Intent goToHomeScreen = new Intent(this, HomeScreenActivity.class);
            startActivity(goToHomeScreen);
        }
    }
}
