package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import onenine.android.R;
import onenine.android.Model.GameDifficulty;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "onenine.android.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates the spinner for difficulties
        Spinner difficultySpinner = findViewById(R.id.gameDifficulty);
        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

    }

    public void onPlayPressed(View view) {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        EditText name = findViewById(R.id.enterNameHere);
        String user = name.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }
}
