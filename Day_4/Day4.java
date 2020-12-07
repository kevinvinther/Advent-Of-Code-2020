import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

import java.util.ArrayList; 

import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.util.Scanner; 

public class Day4 {
    public static int firstPuzzle(String fileName) throws FileNotFoundException {
        FileReader file = new FileReader(fileName);
        Scanner reader = new Scanner(file);

        ArrayList<String> passportInput = new ArrayList<String>();
        ArrayList<String> passports = new ArrayList<String>();

        int validPassports = 0; 
        String temporaryString = ""; 

        while(reader.hasNextLine()) {
            passportInput.add(reader.nextLine());
        }

        for(String passport : passportInput) {
            if(!passport.isEmpty()) {
                temporaryString += passport; 
            } else {
                passports.add(temporaryString);
                temporaryString = ""; 
            }
        }

        String[] fields = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"}; 

        for(String passport : passports) {
            boolean isValid = true; 
            for(String field : fields) {
                Pattern pattern = Pattern.compile(field);
                Matcher matcher = pattern.matcher(passport); 

                if (!matcher.find())
                    isValid = false; 
                
            }
            if(isValid) 
                validPassports += 1; 
        }
        
        return validPassports; 
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(firstPuzzle("input.txt")); 
    }
}
