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

        int firstNumber = 0,
            secondNumber = 0; 
        char letter = 'A'; 

        while(reader.hasNextLine()) {
            passwords.add(reader.nextLine());
        }

        int matches = 0, 
            matches2 = 0; 
        for(String i : passwords) {
            //Pattern pattern = Pattern.compile("[0-9][0-9]?-[0-9][0-9]? [a-z]:");
            Pattern pattern = Pattern.compile("[0-9][0-9]?-[0-9][0-9]?");
            Matcher matcher = pattern.matcher(i);

            matcher.find();
            String[] limits = matcher.group().split("-");

            firstNumber = Integer.parseInt(limits[0]);
            secondNumber = Integer.parseInt(limits[1]);

            pattern = Pattern.compile("[a-z]?:");
            matcher = pattern.matcher(i);

            matcher.find();

            letter = matcher.group().replace(":","").charAt(0);

            String[] patterner = i.split(":"); 
            patterner[1] = patterner[1].replace(" ", "");
            int count = 0; 
            for(int y = 0; y < patterner[1].length(); y++) {
               if(patterner[1].charAt(y) == letter) {
                   count = count + 1;  
                }
            }

            if (count >= firstNumber && count <= secondNumber) {
                matches = matches + 1; 
                System.out.println(limits[0] + "-" + limits[1] + " " + letter + ":" + " " + patterner[1]); 
            }
            if (patterner[1].charAt(firstNumber-1) == letter) {
                if(patterner[1].charAt(secondNumber-1)!=letter) {
                    matches2 = matches2 + 1; 
                }
            } else if (patterner[1].charAt(secondNumber-1) == letter) {
                matches2 = matches2 + 1; 
            }
        }

        System.out.println("First puzzle: " + matches);
        System.out.println("Second puzzle: " + matches2);

    }
}
