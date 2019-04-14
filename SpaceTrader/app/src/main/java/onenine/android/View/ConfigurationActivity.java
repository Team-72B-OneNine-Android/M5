package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import onenine.android.Model.GameDifficulty;
import onenine.android.R;
import onenine.android.ViewModel.ConfigurationActivityViewModel;

/**
 * The activity for the configuration screen
 */
public class ConfigurationActivity extends AppCompatActivity {



    private ConfigurationActivityViewModel vm;

    private static final int SKILLS = 16;
    private TextView playerName;
    private TextView pilotSkill;
    private TextView fighterSkill;
    private TextView traderSkill;
    private TextView engineerSkill;
    private TextView totalSkillPoints;
    private Spinner difficultySpinner;
    private Button playButton;
    private int skillsUsed = SKILLS;

    /**
     * Generates UI for configuration activity
     *
     * @param savedInstanceState the saved instance
     */
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
        playButton = findViewById(R.id.playButton);
        playButton.setEnabled(false);

        //Creates the spinner for difficulties
        difficultySpinner = findViewById(R.id.spinnerDifficulty);
        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);


    }

    /**
     * Checks whether the player has selected the corrected amount of skill points.
     * If user has correct amount of points, then view will change to home screen
     *
     * @param view the view
     */
    public void onPlayPressed(View view) {
        if (Integer.parseInt(totalSkillPoints.getText().toString()) == 0) {
            vm.onConfig(playerName.getText().toString(),
                    Integer.parseInt(pilotSkill.getText().toString()),
                    Integer.parseInt(fighterSkill.getText().toString()),
                    Integer.parseInt(traderSkill.getText().toString()),
                    Integer.parseInt(engineerSkill.getText().toString()),
                    1000,
                    (GameDifficulty) difficultySpinner.getSelectedItem());
            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * Increments the amount of pilot points by one
     *
     * @param view the view
     */
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

    /**
     * Decrements the amount of pilot points by one
     *
     * @param view the view
     */
    public void onPilotDecrementPressed(View view) {
        if ((skillsUsed < SKILLS) && (Integer.parseInt(pilotSkill.getText().toString()) != 0)) {
            int subOne = Integer.parseInt(pilotSkill.getText().toString());
            subOne -= 1;
            pilotSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            disablePlayButton();
        }
    }

    /**
     * Increments the amount of fighter points by one
     *
     * @param view the view
     */
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

    /**
     * Decrements the amount of pilot points by one
     *
     * @param view the view
     */
    public void onFighterDecrementPressed(View view) {
        if ((skillsUsed < SKILLS) && (Integer.parseInt(fighterSkill.getText().toString()) != 0)) {
            int subOne = Integer.parseInt(fighterSkill.getText().toString());
            subOne -= 1;
            fighterSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            disablePlayButton();
        }
    }

    /**
     * Increments the amount of trader points by one
     *
     * @param view the view
     */
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

    /**
     * Decrements the amount of trader points by one
     *
     * @param view the view
     */
    public void onTraderDecrementPressed(View view) {
        if ((skillsUsed < SKILLS) && (Integer.parseInt(traderSkill.getText().toString()) != 0)) {
            int subOne = Integer.parseInt(traderSkill.getText().toString());
            subOne -= 1;
            traderSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            disablePlayButton();
        }
    }

    /**
     * Increments the amount of engineer points by one
     *
     * @param view the view
     */
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

    /**
     * Decrements the amount of engineer points by one
     *
     * @param view the view
     */
    public void onEngineerDecrementPressed(View view) {
        if ((skillsUsed < SKILLS) && (Integer.parseInt(engineerSkill.getText().toString()) != 0)) {
            int subOne = Integer.parseInt(engineerSkill.getText().toString());
            subOne -= 1;
            engineerSkill.setText(String.valueOf(subOne));
            skillsUsed += 1;
            totalSkillPoints.setText(String.valueOf(skillsUsed));
            disablePlayButton();
        }
    }

    /**
     * Allows user to press play button when correct amount of skill points are used
     */
    private void enablePlayButton() {
        if (skillsUsed == 0) {
            playButton.setEnabled(true);
        }
    }

    /**
     * Disables the play button for the user
     */
    private void disablePlayButton() {
        playButton.setEnabled(false);
    }

}
