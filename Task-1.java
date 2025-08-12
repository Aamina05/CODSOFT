import java.util.Random;
import java.util.Scanner;


public class NumberGame {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        boolean keepPlaying = true;
        while (keepPlaying) {
            int maxRange = chooseDifficulty();
            playRound(maxRange);
            keepPlaying = askPlayAgain();
        }
        System.out.println("Thanks for playing — goodbye!");
        SC.close();
    }

    private static int chooseDifficulty() {
        System.out.println("Choose difficulty: 1) Easy (1-20)  2) Normal (1-100)  3) Hard (1-1000)  4) Custom range");
        while (true) {
            System.out.print("Enter choice (1-4): ");
            int choice = readInt();
            switch (choice) {
                case 1: return 20;
                case 2: return 100;
                case 3: return 1000;
                case 4:
                    System.out.print("Enter maximum number (>=2): ");
                    int custom = readInt();
                    if (custom >= 2) return custom;
                    System.out.println("Please enter a number >= 2.");
                    break;
                default:
                    System.out.println("Please enter 1, 2, 3 or 4.");
            }
        }
    }

    private static void playRound(int maxRange) {
        Random rnd = new Random();
        int secret = rnd.nextInt(maxRange) + 1; // 1..maxRange
        System.out.printf("I'm thinking of a number between 1 and %d. Try to guess it!%n", maxRange);
        int attempts = 0;

        while (true) {
            System.out.print("Your guess: ");
            int guess = readInt();
            attempts++;

            if (guess < 1 || guess > maxRange) {
                System.out.printf("Please guess a number between 1 and %d.%n", maxRange);
                continue;
            }

            if (guess == secret) {
                System.out.printf("Correct! You guessed it in %d attempt%s.%n", attempts, attempts == 1 ? "" : "s");
                giveRating(attempts, maxRange);
                break;
            }

            if (guess < secret) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }
        }
    }

    private static void giveRating(int attempts, int maxRange) {
        // A very simple "rating" heuristic
        double expected = Math.log(maxRange) / Math.log(2); // approx optimal guesses
        System.out.printf("(Optimal ~ %.1f guesses)%n", expected);
        if (attempts <= Math.max(1, (int)Math.ceil(expected))) {
            System.out.println("Excellent guessing!");
        } else if (attempts <= expected * 2) {
            System.out.println("Nice — not bad at all.");
        } else {
            System.out.println("Keep practicing! It'll get easier.");
        }
    }

    private static boolean askPlayAgain() {
        System.out.print("Play again? (y/n): ");
        while (true) {
            String line = SC.next().trim().toLowerCase();
            if (line.equals("y") || line.equals("yes")) return true;
            if (line.equals("n") || line.equals("no")) return false;
            System.out.print("Please enter 'y' or 'n': ");
        }
    }

    private static int readInt() {
        while (true) {
            String token = SC.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException ex) {
                System.out.print("That's not a whole number. Try again: ");
            }
        }
    }
}