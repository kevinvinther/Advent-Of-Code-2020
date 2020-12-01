import java.util.Scanner; 
import java.io.FileReader; 
import java.io.FileNotFoundException;
import java.util.ArrayList; 

public class Day1 {
    private static int findNumberWith2(String fileName) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<Integer>(); 

        FileReader file = new FileReader(fileName);

        Scanner reader = new Scanner(file);        
        while (reader.hasNextLine()) {
            numbers.add(Integer.parseInt(reader.nextLine())); 
        }
        reader.close(); 
        for (int num : numbers) {
            for (int num2 : numbers) {
                if (num + num2 == 2020) {
                    return num*num2; 
                }
            }
        }
        return 0; 
    }
    private static int findNumberWith3(String fileName) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<Integer>(); 

        FileReader file = new FileReader(fileName);

        Scanner reader = new Scanner(file);        
        while (reader.hasNextLine()) {
            numbers.add(Integer.parseInt(reader.nextLine())); 
        }
        reader.close(); 
        for (int num : numbers) {
            for (int num2 : numbers) {
                for (int num3 : numbers) {
                    if(num+num2+num3 == 2020) {
                        return num*num2*num3; 
                    }
                }
            }
        }
        return 0; 
    }  
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findNumberWith2("1_1.txt"));
        System.out.println(findNumberWith3("1_1.txt"));
    }
}
