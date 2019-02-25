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

    private String techLevel;

    private TechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    private String getTechLevel() {
        return this.techLevel;
    }
}
