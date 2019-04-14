package onenine.android.ViewModel;

import android.arch.lifecycle.ViewModel;
import onenine.android.Model.Facade;
import onenine.android.Model.GameDifficulty;

/**
 * View model for configuration activity
 */
public class ConfigurationActivityViewModel extends ViewModel {
    private final Facade gameFacade = Facade.getInstance();

    /**
     * Takes information passed from the configuration activity and creates
     * the player and game
     *
     * @param n player name
     * @param p player pilot points
     * @param f player fighter points
     * @param t player trader points
     * @param e player engineer points
     * @param credits player credits
     * @param difficulty game difficulty
     */
    public void onConfig(String n, int p, int f, int t, int e, int credits,
                         GameDifficulty difficulty) {
        gameFacade.setPlayer(n, p, f, t, e, credits);
        gameFacade.setGame(difficulty);
    }

}
