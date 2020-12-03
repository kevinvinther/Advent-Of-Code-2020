import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> passwords = new ArrayList<String>(); 

        FileReader file = new FileReader("passwords.txt");

        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            passwords.add(reader.nextLine());
        }
        for(int i = 0; i < 10; i++) {
           System.out.println(passwords.get(i));
        }

        Pattern pattern = Pattern.compile("^c{2,3}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("cc");

        boolean matchFound = matcher.find();
        
        if(matchFound) {
            System.out.println("Found match");
        } else {
            System.out.println("Did not find match");
        }
    }
}

