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

        int i = 0; 
        for(String passport : passportInput) {
            if(!passport.isEmpty()) {
                temporaryString += passport + " "; 
            } else {
                passports.add(temporaryString);
                temporaryString = ""; 
            }
            i += 1; 
            if(passportInput.size() == i) {
                passports.add(temporaryString);
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
            System.out.println(passport); 
            if(isValid) 
                validPassports += 1; 
        }
        
        return validPassports; 
    }

    public static int secondPuzzle(String fileName) throws FileNotFoundException {
        FileReader file = new FileReader(fileName);
        Scanner reader = new Scanner(file);

        ArrayList<String> passportInput = new ArrayList<String>();
        ArrayList<String> passports = new ArrayList<String>();

        int validPassports = 0; 
        String temporaryString = ""; 

        while(reader.hasNextLine()) {
            passportInput.add(reader.nextLine());
        }

        int i = 0; 
        for(String passport : passportInput) {
            if(!passport.isEmpty()) {
                temporaryString += passport + " "; 
            } else {
                passports.add(temporaryString);
                temporaryString = ""; 
            }
            i += 1; 
            if(passportInput.size() == i) {
                passports.add(temporaryString);
            }

        }
        String[] fields = new String[]{"byr:[0-9]{4}", "iyr:[0-9]{4}", "eyr:[0-9]{4}", "hgt:[0-9]{1,3}[a-z]{2}", "hcl:#[a-f0-9]{6}", "ecl:[a-z]{3}", "pid:[0-9]{9}"}; 

        for(String passport : passports) {
            Pattern pattern = Pattern.compile(fields[0]); 
            Matcher matcher = pattern.matcher(passport); 

            int byr = 0; 
            if(matcher.find()) {
                byr = Integer.parseInt(matcher.group().split(":")[1]);
                if(byr < 1920 || byr > 2002) {
                    continue; 
                } 
            } else {
                continue; 
            }
             
            pattern = Pattern.compile(fields[1]);
            matcher = pattern.matcher(passport); 

            int iyr = 0; 
            if(matcher.find()) {
                iyr = Integer.parseInt(matcher.group().split(":")[1]);
                if(iyr < 2010 || iyr > 2020) {
                    continue; 
                } 
            } else {
                continue; 
            }

            pattern = Pattern.compile(fields[2]);
            matcher = pattern.matcher(passport);

            int eyr = 0; 
            if(matcher.find()) {
                eyr =  Integer.parseInt(matcher.group().split(":")[1]);
                if (eyr < 2020 || eyr > 2030) { 
                    continue; 
                } 
            } else {
                continue;
            }

            pattern = Pattern.compile(fields[3]);
            matcher = pattern.matcher(passport);

            int hgt = 0; 
            if(matcher.find()) {
                if(matcher.group().contains("cm")) {
                   hgt = Integer.parseInt(matcher.group().split(":")[1].replace("cm", "")); 
                   if(hgt < 150 || hgt > 193) {
                        continue; 
                    } 
                } else if (matcher.group().contains("in")) {
                    hgt = Integer.parseInt(matcher.group().split(":")[1].replace("in", ""));
                    if(hgt < 59 || hgt > 76) {
                        continue; 
                    } 
                }
            } else {
                continue; 
            }

            pattern = Pattern.compile(fields[4]);
            matcher = pattern.matcher(passport);

            String hcl = "";  
            if(!matcher.find()) {
                continue; 
            } else {
                hcl = matcher.group().split(":")[1];
            }

            pattern = Pattern.compile(fields[5]); 
            matcher = pattern.matcher(passport);

            String ecl = ""; 
            if(matcher.find()) {
                ecl = matcher.group().split(":")[1]; 
                String[] colors = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}; 
                boolean validHcl = false; 
                for(String color : colors) {
                    if(ecl.equals(color)) {
                        validHcl = true; 
                        break; 
                    } else {
                        validHcl = false; 
                    }
                }
                if(!validHcl) {
                    continue; 
                }
            } else{
                continue; 
            }
            

            pattern = Pattern.compile(fields[6]); 
            matcher = pattern.matcher(passport);

            String pid = "";  
            if(matcher.find()) {
                pid = matcher.group().split(":")[1]; 
                if(pid.length() != 9) {
                    continue; 
                }
            } else {
                continue; 
            }
            System.out.println("byr:"+byr);
            System.out.println("iyr:"+iyr);
            System.out.println("eyr:"+eyr);
            System.out.println("hgt:"+hgt);
            System.out.println("hcl:"+hcl);
            System.out.println("ecl:"+ecl);
            System.out.println("pid:"+pid);
            System.out.println();
            validPassports += 1; 
        }
        return validPassports; 
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(secondPuzzle("input.txt")); 
    }
}
