import java.time.*;
import java.util.*;

public class DictionGame {

    static class WordData {
        String word;
        String country;
        String timePeriod;
        String definition;
        String synonyms;
        String sentence;
        String difficulty;

        public WordData(String word, String country, String timePeriod, String definition, String synonyms, String sentence, String difficulty) {
            this.word = word.toLowerCase();
            this.country = country;
            this.timePeriod = timePeriod;
            this.definition = definition;
            this.synonyms = synonyms;
            this.sentence = sentence;
            this.difficulty = difficulty;
        }
    }

    // list of all the words in the game
    private static final List<WordData> Dictionary = Arrays.asList(
            // Easy words
            new WordData("ant", "England (Old English)", "Pre-12th Century",
                    "A small insect that lives in complex social colonies.",
                    "insect, bug, worker",
                    "A single _____ was carrying a crumb across the sidewalk.", "Easy"),
            new WordData("map", "Latin (mappa 'napkin/cloth')", "16th Century",
                    "A diagrammatic representation of an area of land or sea.",
                    "chart, plan, atlas",
                    "She unfolded the paper _____ to find the right hiking trail.", "Easy"),
            new WordData("book", "England (Old English)", "Pre-12th Century",
                    "A written or printed work consisting of pages glued together.",
                    "volume, novel, publication",
                    "He sat by the window reading an interesting _____.", "Easy"),
            new WordData("star", "England (Old English)", "Pre-12th Century",
                    "A fixed luminous point in the night sky.",
                    "celestial body, sun, luminary",
                    "We wished upon a shooting _____ crossing the dark sky.", "Easy"),
            new WordData("pen", "Latin (penna 'feather')", "14th Century",
                    "An instrument for writing or drawing with ink.",
                    "ballpoint, marker, quill",
                    "He signed the official document with a black ink _____.", "Easy"),
            new WordData("box", "England (Old English)", "Pre-12th Century",
                    "A container with a flat base and sides, typically rectangular.",
                    "carton, crate, chest",
                    "She packed her old books safely away inside a cardboard _____.", "Easy"),

            // Intermediate words
            new WordData("beach", "England", "16th Century",
                    "A pebbly or sandy shore by the ocean or a lake.",
                    "coast, shore, strand",
                    "The kids built a massive sandcastle on the _____.", "Intermediate"),
            new WordData("tiger", "Greece / Persia", "Ancient Era",
                    "A very large solitary cat with dark vertical stripes on reddish-orange fur.",
                    "feline, beast, big cat",
                    "The majestic _____ prowled quietly through the tall grass.", "Intermediate"),
            new WordData("bridge", "England (Old English)", "Pre-12th Century",
                    "A structure carrying a road or path across an obstacle.",
                    "viaduct, span, crossing",
                    "Cars crossed slowly over the long steel _____ during rush hour.", "Intermediate"),
            new WordData("planet", "Greece (planētēs 'wanderer')", "Ancient Era",
                    "A large celestial body orbiting a star.",
                    "world, orb, globe",
                    "Earth is the third _____ from the sun.", "Intermediate"),
            new WordData("clock", "Latin / Celtic origin via Medieval Dutch", "14th Century",
                    "A mechanical or electrical device for measuring time.",
                    "timepiece, watch, timer",
                    "The kitchen _____ ticked loudly as midnight approached.", "Intermediate"),
            new WordData("river", "France (rivière)", "13th Century",
                    "A large natural stream of water flowing in a channel to the sea.",
                    "stream, brook, waterway",
                    "A rapid flowing _____ carved its way right through the canyon.", "Intermediate"),
            new WordData("guitar", "Spain (derived from Persian/Greek)", "16th Century",
                    "A fretted musical instrument with usually six strings, played by strumming or plucking.",
                    "lute, acoustic, string-instrument",
                    "He sat on the porch and strummed a melancholic tune on his _____.", "Intermediate"),
            new WordData("karate", "Japan (Okinawa)", "17th Century",
                    "A Japanese system of close combat without weapons, using striking and kicking.",
                    "martial-arts, self-defense, combat",
                    "He earned his black belt in _____ after years of rigorous training.", "Intermediate"),
            new WordData("anchor", "Greece / Ancient Mediterranean", "Ancient Era",
                    "A heavy object attached to a vessel by a cable or chain and dropped to the seabed to keep the vessel in place.",
                    "hook, mooring, fastener",
                    "The captain dropped the _____ in the calm bay.", "Intermediate"),
            new WordData("safari", "Kenya / Tanzania (Swahili origin)", "19th Century",
                    "An expedition or journey, typically to observe wildlife in their natural habitat.",
                    "expedition, tour, trip",
                    "We went on a thrilling _____ across the savannah.", "Intermediate"),
            new WordData("umbrella", "China / Egypt (Ancient), modern term from Italy", "16th Century",
                    "A collapsible canopy supported by wooden or metal ribs, used for protection against rain or sunlight.",
                    "parasol, brolly, rainshade",
                    "She opened her _____ as the heavy rain started to fall.", "Intermediate"),
            new WordData("whiskey", "Ireland / Scotland", "15th Century",
                    "A type of distilled alcoholic beverage made from fermented grain mash.",
                    "bourbon, scotch, liquor",
                    "They poured a glass of _____ by the fireplace.", "Intermediate"),
            new WordData("dolphin", "Greece (delphis)", "Ancient Era",
                    "A small gregarious marine mammal known for intelligence and playful behavior.",
                    "porpoise, marine-mammal",
                    "A friendly _____ leaped gracefully out of the ocean waves.", "Intermediate"),
            new WordData("kitchen", "England (Old English)", "Pre-12th Century",
                    "A room or area prepared for cooking and food preparation.",
                    "cookroom, culinary-space",
                    "The delicious aroma of baking bread drifted from the _____.", "Intermediate"),
            new WordData("forest", "France (forestis)", "13th Century",
                    "A large area covered chiefly with trees and undergrowth.",
                    "woods, woodland, timberland",
                    "Sunlight filtered beautifully through the tall pines in the dense _____.", "Intermediate"),
            new WordData("window", "Old Norse (vindauga 'wind-eye')", "Pre-12th Century",
                    "An opening in the wall or roof of a building that can admit light or air.",
                    "opening, pane, casement",
                    "Raindrops pattered softly against the glass _____ pane.", "Intermediate"),
            new WordData("station", "Latin (statio)", "13th Century",
                    "A place where regular stopping takes place.",
                    "terminal, stop, depot",
                    "They waited on the platform at the railway _____ for the train.", "Intermediate"),

            // Hard words
            new WordData("mountain", "France (montaine)", "13th Century",
                    "A large natural elevation of the earth's surface rising abruptly.",
                    "peak, hill, mount",
                    "Snow capped the high summit of the rugged _____.", "Hard"),
            new WordData("notebook", "England", "16th Century",
                    "A book with blank pages for writing notes in.",
                    "pad, journal, diary",
                    "She jotted down her brilliant idea in her leather _____.", "Hard"),
            new WordData("telescope", "Greece / France", "17th Century",
                    "An optical instrument designed to make distant objects appear nearer.",
                    "scope, spyglass, refractor",
                    "We looked through the powerful _____ to see the rings of Saturn.", "Hard"),
            new WordData("sunflower", "England", "16th Century",
                    "A tall plant bearing very large golden flower heads.",
                    "bloom, plant, flora",
                    "The bright yellow _____ turned its face toward the warm sun.", "Hard"),
            new WordData("adventure", "France (aventure)", "13th Century",
                    "An unusual and exciting, typically hazardous, experience or activity.",
                    "escapade, journey, quest",
                    "They packed their bags and set off on a grand _____ across Europe.", "Hard"),
            new WordData("lighthouse", "England", "Pre-12th Century",
                    "A tower or other structure containing a beacon light to warn or guide ships.",
                    "beacon, tower, signal",
                    "The bright beam from the coastal _____ guided ships safely through the storm.", "Hard"),
            new WordData("helicopter", "France (hélicoptère)", "19th Century",
                    "A type of aircraft deriving both lift and propulsion from one or more sets of horizontally revolving rotors.",
                    "copter, chopper, aircraft",
                    "The rescue _____ hovered steadily above the stranded hikers.", "Hard"),
            new WordData("skyscraper", "United States", "19th Century",
                    "A very tall building of many stories.",
                    "tower, high-rise, block",
                    "From the top floor of the massive _____, the city looked like a miniature model.", "Hard"),
            new WordData("festival", "Latin (festivus)", "14th Century",
                    "A day or period of celebration, typically for religious or cultural reasons.",
                    "celebration, gala, carnival",
                    "The town gathered in the square every autumn for the harvest _____.", "Hard"),
            new WordData("astronaut", "Greek (astron 'star' + nautēs 'sailor')", "20th Century",
                    "A person who is trained to travel in a spacecraft.",
                    "spaceman, cosmonaut, explorer",
                    "The brave _____ floated inside the space station in zero gravity.", "Hard"),

            // Expert words
            new WordData("archaeology", "Greece (arkhaiologia)", "17th Century",
                    "The study of human history and prehistory through the excavation of sites.",
                    "excavation, antiquity-study",
                    "She spent her summer in Egypt pursuing a degree in _____.", "Expert"),
            new WordData("kaleidoscope", "Greece (kalos 'beautiful' + eidos 'form')", "19th Century",
                    "A toy consisting of a tube containing mirrors and pieces of colored glass.",
                    "optical-toy, pattern-tube",
                    "Rotating the glass end of the _____ created an endless stream of geometric patterns.", "Expert"),
            new WordData("temperature", "Latin (temperatura)", "16th Century",
                    "The degree or intensity of heat present in a substance or object.",
                    "heat, warmth, reading",
                    "The digital thermometer showed that the outdoor _____ had dropped below freezing.", "Expert")
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        loadingScreen();

        boolean playAgain = true;
        while (playAgain) {
            WordData puzzle = Dictionary.get(random.nextInt(Dictionary.size()));
            playGame(scanner, puzzle);

            System.out.print("\nWould you like to play another round? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.startsWith("y");
        }

        System.out.println("\nThanks for playing DICTION!");
        scanner.close();
    }

    private static void loadingScreen() { //loading screen
        System.out.println("==================================================");
        System.out.println("                D I C T I O N                     ");
        System.out.println("         A Text Based Word Guessing Game!         ");
        System.out.println("==================================================");
    }

    private static void playGame(Scanner scanner, WordData puzzle) {
        int length = puzzle.word.length();
        char[] currentGuessState = new char[length];
        Arrays.fill(currentGuessState, '_');

        int wrongGuesses = 0;
        long penaltySeconds = 0;
        Instant startTime = Instant.now();

        System.out.println("\nA new word has been loaded! (" + length + " letters)");

        boolean solved = false;
        while (!solved) {

            long elapsedSeconds = Duration.between(startTime, Instant.now()).getSeconds() + penaltySeconds;

            System.out.println("\n--------------------------------------------------");
            System.out.printf(" TIMER: %02d:%02d | Level: %-9s | Mistakes: %d/5\n", //details for the User Inferface
                    elapsedSeconds / 60, elapsedSeconds % 60, puzzle.difficulty, wrongGuesses);
            System.out.println(" WORD:  " + getFormattedWordState(currentGuessState));
            System.out.println("--------------------------------------------------");

            displayClues(puzzle, wrongGuesses);

            System.out.print("\nEnter a letter or full word guess: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            if (input.equals(puzzle.word)) {
                solved = true;
                break;
            }

            if (input.length() == 1) {
                char letter = input.charAt(0);
                boolean found = false;
                for (int i = 0; i < length; i++) {
                    if (puzzle.word.charAt(i) == letter) {
                        currentGuessState[i] = letter;
                        found = true;
                    }
                }

                if (found) {
                    System.out.println("-> Correct letter found!");
                    if (String.valueOf(currentGuessState).equals(puzzle.word)) {
                        solved = true;
                        break;
                    }
                } else { //make sure that the guess is the right amount of letters
                    wrongGuesses++;
                    penaltySeconds += 5;
                    System.out.println("-> Incorrect letter! +5 seconds penalty. A new clue has unlocked.");
                }
            } else {
                wrongGuesses++;
                penaltySeconds += 5;
                System.out.println("-> Incorrect word! +5 seconds penalty. A new clue has unlocked.");
            }
        }

        long finalTime = Duration.between(startTime, Instant.now()).getSeconds() + penaltySeconds; //final time

        triggerConfettiEffect();
        System.out.println("\n*** CONGRATULATIONS! You solved the word: " + puzzle.word.toUpperCase() + " ***");
        System.out.printf("Final Time: %02d:%02d (%d total seconds)\n", finalTime / 60, finalTime % 60, finalTime); //celebration/win screen
    }

    private static String getFormattedWordState(char[] state) {
        StringBuilder sb = new StringBuilder();
        for (char c : state) {
            sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }

    private static void displayClues(WordData puzzle, int wrongGuesses) {
        System.out.println("\n[CLUES UNLOCKED]");

        System.out.println(" 1. Country of Origin: " + puzzle.country);

        // Clue 2: time period when it was first used
        if (wrongGuesses >= 1) {
            System.out.println(" 2. Time Period:       " + puzzle.timePeriod);
        } else {
            System.out.println(" 2. Time Period:       [Locked - Make 1 wrong guess to reveal]");
        }

        // Clue 3: textbook definition
        if (wrongGuesses >= 2) {
            System.out.println(" 3. Definition:        " + puzzle.definition);
        } else {
            System.out.println(" 3. Definition:        [Locked - Make 2 wrong guesses to reveal]");
        }

        // Clue 4: synonyms
        if (wrongGuesses >= 3) {
            System.out.println(" 4. Synonyms:          " + puzzle.synonyms);
        } else {
            System.out.println(" 4. Synonyms:          [Locked - Make 3 wrong guesses to reveal]");
        }

        // Clue 5: in a sentence
        if (wrongGuesses >= 4) {
            System.out.println(" 5. Sentence Context:  " + puzzle.sentence);
        } else {
            System.out.println(" 5. Sentence Context:  [Locked - Make 4 wrong guesses to reveal]");
        }
    }

    private static void triggerConfettiEffect() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  * . * . `. , * CONGRATULATIONS! *  .  .  * .  ' ");
        System.out.println("    .  *  .  *  . * YOU WON! * , .  *  .  *  .  * ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}