package onenine.android.Model;

import java.util.Random;

public enum Events {
    NO_EVENT,
    LOSE_CARGO,
    LOSE_CREDIT,
    GAIN_CREDIT;

    private static final int CHANCE = 60;

    public static Events checkForEvent() {
        int random = new Random().nextInt(100);
        Events[] possibleEvents = Events.values();
        int randomEvent = new Random().nextInt(possibleEvents.length - 1);
        randomEvent += 1;
        if (random > CHANCE) {
            return possibleEvents[randomEvent];
        } else {
            return possibleEvents[0];
        }
    }

    public static String getEventMessage(Events events) {
        if (events == LOSE_CARGO) {
            return "Somebody stole all your cargo!";
        } else if (events == LOSE_CREDIT) {
            return "UGA Student took your money!";
        } else if (events == GAIN_CREDIT) {
            return "You got a trader bonus!";
        } else {
            return "";
        }
    }
}
