import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        System.out.println("test");

        try {
            File input = new File("1/input.txt");
            Scanner reader = new Scanner(input);
            long sum = 0;
            int lineNum = 0;
            while(reader.hasNextLine()) {
                int first = -1, last = -1;
                char[] line = reader.nextLine().toCharArray();
                // find the first left number
                for(int i = 0; i < line.length; i++) {
                    if(Character.isDigit(line[i])) {
                        if(first == -1) {
                            first = line[i] - 48;
                        }

                        last = line[i] - 48;
                    }
                }

                lineNum = ((first * 10) + last);
                sum += lineNum;
                
                System.out.println(lineNum + " - " + sum);
            }

            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
            e.printStackTrace();
        }

    }

}