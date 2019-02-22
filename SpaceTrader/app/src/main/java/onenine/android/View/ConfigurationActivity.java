package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import onenine.android.Model.GameDifficulty;
import onenine.android.Model.Player;
import onenine.android.R;
import onenine.android.ViewModel.ConfigurationActivityViewModel;

public class ConfigurationActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "onenine.android.MESSAGE";


    private ConfigurationActivityViewModel vm;

    TextView playerName;
    TextView pilotSkill;
    TextView fighterSkill;
    TextView traderSkill;
    TextView engineerSkill;
    TextView totalSkillPoints;
    Spinner difficultySpinner;
    Button playButton;
    int skillsUsed = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        setContentView(R.layout.activity_configure);
        vm = ViewModelProviders.of(this).get(ConfigurationActivityViewModel.class);

        playerName = findViewById(R.id.enterNameHere);
        pilotSkill = findViewById(R.id.pilotSkill);
        fighterSkill = findViewById(R.id.fighterSkill);
        traderSkill = findViewById(R.id.traderSkill);
        engineerSkill = findViewById(R.id.engineerSkill);
        totalSkillPoints = findViewById(R.id.totalSkillPoints);
        playButton = findViewById(R.id.play);
        playButton.setEnabled(false);

        //Creates the spinner for difficulties
        difficultySpinner = findViewById(R.id.spinnerDifficulty);
        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);


    }

    public void onPlayPressed(View view) {
        if (Integer.parseInt(totalSkillPoints.getText().toString()) == 0) {
            vm.onConfig(playerName.getText().toString(), Integer.parseInt(pilotSkill.getText().toString()),
                    Integer.parseInt(fighterSkill.getText().toString()),
                    Integer.parseInt(traderSkill.getText().toString()),
                    Integer.parseInt(engineerSkill.getText().toString()), (GameDifficulty) difficultySpinner.getSelectedItem());

            Intent intent = new Intent(this, HomeScreenActivity.class);
            EditText name = findViewById(R.id.enterNameHere);
            String user = name.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, user);
            startActivity(intent);
            finish();
        }
    }

    public void onPilotIncrementPressed(View view) {
        if (skillsUsed > 0) {
            int addOne = Integer.parseInt(pilotSkill.getText().toString());
            addOne += 1;
            pilotSkill.setText(String.valueOf(addOne));
            skillsUsed -= 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }
    public void onPilotDecrementPressed(View view) {
        if (skillsUsed < 16 && Integer.parseInt(pilotSkill.getText().toString()) != 0) {
            int subOne = Integer.parseInt(pilotSkill.getText().toString());
            subOne -= 1;
            pilotSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onFighterIncrementPressed(View view) {
        if (skillsUsed > 0) {
            int addOne = Integer.parseInt(fighterSkill.getText().toString());
            addOne += 1;
            fighterSkill.setText(String.valueOf(addOne));
            skillsUsed -= 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onFighterDecrementPressed(View view) {
        if (skillsUsed < 16 && Integer.parseInt(fighterSkill.getText().toString()) != 0) {
            int subOne = Integer.parseInt(fighterSkill.getText().toString());
            subOne -= 1;
            fighterSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onTraderIncrementPressed(View view) {
        if (skillsUsed > 0) {
            int addOne = Integer.parseInt(traderSkill.getText().toString());
            addOne += 1;
            traderSkill.setText(String.valueOf(addOne));
            skillsUsed -= 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onTraderDecrementPressed(View view) {
        if (skillsUsed < 16 && Integer.parseInt(traderSkill.getText().toString()) != 0) {
            int subOne = Integer.parseInt(traderSkill.getText().toString());
            subOne -= 1;
            traderSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onEngineerIncrementPressed(View view) {
        if (skillsUsed > 0) {
            int addOne = Integer.parseInt(engineerSkill.getText().toString());
            addOne += 1;
            engineerSkill.setText(String.valueOf(addOne));
            skillsUsed -= 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    public void onEngineerDecrementPressed(View view) {
        if (skillsUsed < 16 && Integer.parseInt(engineerSkill.getText().toString()) != 0) {
            int subOne = Integer.parseInt(engineerSkill.getText().toString());
            subOne -= 1;
            engineerSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            enablePlayButton();
        }
    }

    private void enablePlayButton() {
        if (skillsUsed == 0) {
            playButton.setEnabled(true);
        } else {
            playButton.setEnabled(false);
        }
    }
}
