import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        System.out.println("test");

        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            long sum = 0;
            int lineNum = 0;
            while(reader.hasNextLine()) {
                char[] line = reader.nextLine().toCharArray();
                // find the first left number
                for(int i = 0; i < line.length; i++) {
                    if(Character.isDigit(line[i])) {
                        lineNum = ((line[i] - 48) * 10);
                        // sum = sum + lineNum;
                        break;
                    }
                }

                // find the first number from right
                for(int j = line.length - 1; j >= 0; j--){ 
                    if(Character.isDigit(line[j])) {
                        lineNum += (line[j] - 48);
                        sum = sum + lineNum;
                        break;
                    }
                }
                
                System.out.println(lineNum + " - " + sum);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
            e.printStackTrace();
        }

    }

}