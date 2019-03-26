package onenine.android.Model;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture"),
    AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLY_INDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"),
    POST_INDUSTRIAL("Post Industrial"),
    HI_TECH("Hi-Tech");

    private final String techLevel;

    TechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

}
