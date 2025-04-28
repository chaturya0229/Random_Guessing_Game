public class Checknumber
{
    private int secretNumber;

    public Checknumber(int secretNumber)
    {
        this.secretNumber = secretNumber;
    }
    public String guessChecking(int guess)
    {
        if(guess < secretNumber)
        {
            return "Too low. Can you Please Try again.";
        }
        else if(guess > secretNumber)
        {
            return "Too high. Try again.";
        }
        else
        {
            return "Congratulations! You're mind reader! That's Correct.";
        }
    }
}