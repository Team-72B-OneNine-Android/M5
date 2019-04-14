package onenine.android.Model;

import java.io.Serializable;

class PlanetAttributes implements Serializable {

    private final String[] planets = {
            "Acamar",
            "Adahn",
            "Aldea",
            "Andevian",
            "Antedi",
            "Balosnee",
            "Baratas",
            "Brax",			// One of the heroes in Master of Magic
            "Bretel",		// This is a Dutch device for keeping your pants up.
            "Calondia",
            "Campor",
            "Capelle",		// The city I lived in while programming this game
            "Carzon",
            "Castor",
            "Cestus",
            "Cheron",
            "Courteney",	// After Courteney Cox…
            "Daled",
            "Damast",
            "Davlos",
            "Deneb",
            "Deneva",
            "Devidia",
            "Draylon",
            "Drema",
            "Endor",
            "Esmee",
            "Exo",
            "Ferris",		// Iron
            "Festen",		// A great Scandinavian movie
            "Fourmi",		// An ant, in French
            "Frolix",		// A solar system in one of Philip K. Dick's novels
            "Gemulon",
            "Guinifer",		// One way of writing the name of king Arthur's wife
            "Hades",		// The underworld
            "Hamlet",		// From Shakespeare
            "Helena",		// Of Troy
            "Hulst",		// A Dutch plant
            "Iodine",		// An element
            "Iralius",
            "Janus",		// A seldom encountered Dutch boy's name
            "Japori",
            "Jarada",
            "Jason",		// A Greek hero
            "Kaylon",
            "Khefka",
            "Kira",			// My dog's name
            "Klaatu",		// From a classic SF movie
            "Klaestron",
            "Korma",		// An Indian sauce
            "Kravat",		// Interesting spelling of the French word for "tie"
            "Krios",
            "Laertes",		// A king in a Greek tragedy
            "Largo",
            "Lave",			// The starting system in Elite
            "Ligon",
            "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
            "Magrat",
            "Malcoria",
            "Melina",
            "Mentar",
            "Merik",
            "Mintaka",
            "Montor",
            "Mordan",
            "Myrthe",		// The name of my daughter
            "Nelvana",
            "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
            "Nyle",			// An interesting spelling of the great river
            "Odet",
            "Og",
            "Omega",		// The end of it all
            "Omphalos",		// Greek for navel
            "Orias",
            "Othello",		// From Shakespeare
            "Parade",		// This word means the same in Dutch and in English
            "Penthara",
            "Picard",		// The enigmatic captain from ST:TNG
            "Pollux",		// Brother of Castor
            "Quator",
            "Rakhar",
            "Ran",
            "Regulas",
            "Relva",
            "Rhymus",
            "Rochani",
            "Rubicum",
            "Rutia",
            "Sarpeidon",
            "Sefalla",
            "Seltrice",
            "Sigma",
            "Sol",			// That's our own solar system
            "Somari",
            "Stakoron",
            "Styris",
            "Talani",
            "Tamus",
            "Tantalos",		// A king from a Greek tragedy
            "Tanuga",
            "Tarchannen",
            "Terosa",
            "Thera",		// A seldom encountered Dutch girl's name
            "Titan",		// The largest moon of Jupiter
            "Torin",		// A hero from Master of Magic
            "Triacus",
            "Turkana",
            "Tyrus",
            "Umberlee",
            "Utopia",		// The ultimate goal
            "Vadera",
            "Vagra",
            "Vandor",
            "Ventax",
            "Xenon",
            "Xerxes",		// A Greek hero
            "Yew",
            "Yojimbo",
            "Zalkon",
            "Zuul"
    };

    private final String[] resources = {
            "NOSPECIALRESOURCES",
            "MINERALRICH",
            "MINERALPOOR",
            "DESERT",
            "LOTSOFWATER",
            "RICHSOIL",
            "POORSOIL",
            "RICHFAUNA",
            "LIFELESS",
            "WEIRDMUSHROOMS",
            "LOTSOFHERBS",
            "ARTISTIC",
            "WARLIKE"
    };

    /**
     * Gets all of the possible planets
     *
     * @return the planets that can be used to create a solar system
     */
    public String[] getPlanetsStringArray() {
        return planets;
    }

    /**
     * Gets all of the possible resources
     *
     * @return the resources that can be associated with a planet
     */
    public String[] getResourcesStringArray() {
        return resources;
    }



}
