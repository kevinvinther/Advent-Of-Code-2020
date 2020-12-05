import java.io.FileNotFoundException; 
import java.util.ArrayList; 
import java.io.FileReader; 
import java.util.Scanner; 

public class Day3 {
    public static int solvePuzzle(String fileName) throws FileNotFoundException {
        ArrayList<String> map = new ArrayList<String>(); 

        FileReader file = new FileReader(fileName); 

        Scanner reader = new Scanner(file);

        int positionX = 0;

        while(reader.hasNextLine()) {
            map.add(reader.nextLine());
        }

        int treesHit = 0; 

        for(String i : map) {
            if(positionX >= i.length()) 
                positionX = positionX - i.length();

            if(i.charAt(positionX) == '#') {
                treesHit += 1; 
                System.out.println("Tree hit at coordinate " + positionX + ", where following letter is: " + i.charAt(positionX));
            }
            positionX += 3;
        }
        return treesHit; 
    }

    public static int solvePuzzle2(String fileName) throws FileNotFoundException {
        ArrayList<String> map = new ArrayList<String>(); 

        FileReader file = new FileReader(fileName); 

        Scanner reader = new Scanner(file); 

        int positionX = 0, 
            positionY = 0;

        int[] results = new int[5]; 

        while(reader.hasNextLine()) {
            map.add(reader.nextLine()); 
        }

        //Right 3, down 1
        for(String i : map) {
            if(positionX >= i.length()) 
                positionX = positionX - i.length();

            if(i.charAt(positionX) == '#') {
                results[0] += 1; 
            }
            positionX += 3;
        }

        positionX = 0; 
        //Right 1, down 1
        for(String i : map) {
            if(positionX >= i.length()) 
                positionX = positionX - i.length();

            if(i.charAt(positionX) == '#') {
                results[1] += 1; 
            }
            positionX += 1;
        }
        
        positionX = 0; 
        //Right 5, down 1
        for(String i : map) {
            if(positionX >= i.length()) 
                positionX = positionX - i.length();

            if(i.charAt(positionX) == '#') {
                results[2] += 1; 
            }
            positionX += 5;
        }

        positionX = 0; 
        //Right 7, down 1
        for(String i : map) {
            if(positionX >= i.length()) 
                positionX = positionX - i.length();

            if(i.charAt(positionX) == '#') {
                results[3] += 1; 
            }
            positionX += 7;
        }

        positionX = 0; 
        //Right 1, down 2
        for(String i : map) {
            if(positionY % 2 == 0) {
                if(positionX >= i.length()) 
                    positionX = positionX - i.length();

                if(i.charAt(positionX) == '#') {
                    results[4] += 1; 
                }
                positionX += 1;
            } 
            positionY += 1; 
        }

        for(int i : results) {
            System.out.println(i);
        }
        return results[0] * results[1] * results[2] * results[3] * results[4]; 
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(solvePuzzle2("map.txt"));
    }
}
