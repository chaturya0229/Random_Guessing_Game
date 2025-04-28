import java.util.ArrayList;
import java.util.List;
public class ScrollHistory
{
    private List<Integer> historyNumber;

    public ScrollHistory()
    {
        this.historyNumber = new ArrayList<>();
    }

    public void InputGuess(int guess)
    {
        this.historyNumber.add(guess);
    }

    public void ShowHistory()
    {
        if(!historyNumber.isEmpty())
        {
            System.out.println("Your before guesses:");

            for(int i = 0 ; i<historyNumber.size(); i++)
            {
                System.out.println(historyNumber.get(i));
                if(i < historyNumber.size()-1)
                {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}