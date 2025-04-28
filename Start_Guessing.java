import java.util.Random;
import java.util.Scanner;

public class Start_Guessing{
    private int secretNumber;
    private User user;
    private StartGame inputHandler;
    private ScrollHistory guessHistory;
    private Checknumber checker;
    private ExitGame gameExiter;

    public Start_Guessing() {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        this.user = new User();
        this.inputHandler = new StartGame();
        this.guessHistory = new ScrollHistory();
        this.checker = new Checknumber(secretNumber);
        this.gameExiter = new ExitGame();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, Time to test your Luck in the guessing zone!");
        System.out.print("Enter your player name: ");
        String playerName = scanner.nextLine();
        user.setName(playerName);
        System.out.println("Hello, " + user.getName() + "! Try to guess the number between 1 and 100.");

        int guess;
        do {
            guess = inputHandler.getUserGuess(scanner);
            user.incrementAttempts();
            guessHistory.InputGuess(guess);

            String result = checker.guessChecking(guess);
            System.out.println(result);
            guessHistory.ShowHistory();

            if (result.equals("Congratulations! You guessed the correct number.")) {
                System.out.println("You guessed it in " + user.getAttempts() + " attempts.");
                break;
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                gameExiter.exitgame();
                break;
            }

        } while (true);

        scanner.close();
    }

    public static void main(String[] args) {
        Start_Guessing game = new Start_Guessing();
        game.playGame();
    }
}