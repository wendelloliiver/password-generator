import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator 
{
    private Random generator = new Random();
    private ArrayList<String> password = new ArrayList<>();

    public static String[] words = 
    {
        "a", "b", "c", "d", "e", "f", "g",
        "h", "i", "j", "k", "l", "m", "n",
        "o", "p", "q", "r", "s", "t", "u",
        "v", "w", "x", "y", "z", "A", "B",
        "C", "D", "E", "F", "G", "H", "I",
        "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W",
        "X", "Y", "Z", "1", "2", "3", "4",
        "5", "6", "7", "8", "9", "0", " ",
        "!", "@", "#", "$", "%", "^", "&",
        "*", "(", ")", ":", ";", "?", "+"
    };

    public PasswordGenerator(int index)
    {
        randomizePassword(strongPassword(index));
    }

    private int strongPassword(int index)
    {
        int choice = index;

        int n = 0;

        switch (choice) 
        {
            case 0:
                n = 8;
                break;
            case 1:
                n = 16;
                break;
            case 2:
                n = 32;
                break;
            default:
                n = 16;
                break;
        }

        return n;
    }

    private void randomizePassword(int n)
    {
        for (int i = 0; i <= n; i++)
        {
            password.add(words[generator.nextInt(words.length)]);
        }
    }

    public String getNewPassword()
    {
        String pass = "";
        for (int i = 0; i < password.size(); i++)
        {
            pass += password.get(i);
        }

        return pass;
    }
}
