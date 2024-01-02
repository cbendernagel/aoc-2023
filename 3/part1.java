import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Part1 {
    
    public static void main(String[] args) {
        try{
            File input = new File("./input.txt");
            Scanner reader = new Scanner(input);

            char[] line3 = reader.nextLine().toCharArray();
            char[] line1 = new char[line3.length];
            char[] line2 = new char[line3.length];

            int total = 0, num = -1;

            while(reader.hasNextLine()) {
                line1 = line2;
                line2 = line3;
                line3 = reader.nextLine().toCharArray();

                boolean symbol = false;
                for(int i = 0; i < line2.length; i++){
                    char c = line2[i];
                    if(Character.isDigit(c)) {
                        if(num == -1)
                            num = c - '0';
                        else {
                            num *= 10;
                            num += c - '0';
                        }

                        symbol = symbol || isAdjacent(line2, line1, line3, i);
                    }
                    if(!Character.isDigit(c) || i == line2.length - 1) {
                        if(num != -1 && symbol) {
                            total += num;
                            System.out.print(num + "-");
                        }
                            
                        num = -1;
                        symbol = false;
                    }

                   
                }
                System.out.println();
            }

            // check last line
            line1 = line2;
            line2 = line3;
            char[] line4 = new char[line2.length];

            boolean symbol = false;
            for(int i = 0; i < line2.length; i++){
                char c = line2[i];
                if(Character.isDigit(c)) {
                    if(num == -1)
                        num = c - '0';
                    else {
                        num *= 10;
                        num += c - '0';
                    }

                    symbol = symbol || isAdjacent(line2, line1, line4, i);
                } 
                if(!Character.isDigit(c) || i == line2.length - 1) {
                    if((num != -1 && symbol)) {
                        total += num;
                        System.out.print(num + "-");
                    }
                        
                    
                    num = -1;
                    symbol = false;
                }
            }
            System.out.println();
            System.out.println(total);
            reader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("file does not exist");
            e.printStackTrace();
        }
    }

    public static boolean isAdjacent(char[] line, char[] above, char[] below, int i) {
        // left
        int left = i - 1;
        if(left > 0) {
            // up left
            if(above[left] != '\u0000' && above[left] != '.' && !Character.isDigit(above[left])){
                return true;
            }
                

            // left 
            if(line[left] != '.' && !Character.isDigit(line[left])){
                return true;
            }

            // below left
            if(below[left] != '\u0000' && below[left] != '.' && !Character.isDigit(below[left])){
                return true;
            }
        }

        // right
        int right = i + 1;
        if(right < line.length) {
            // up right
            if(above[right] != '\u0000' && above[right] != '.' && !Character.isDigit(above[right])){
                return true;
            }

            // right 
            if(line[right] != '.' && !Character.isDigit(line[right])){
                return true;
            }

            // below right
            if(below[right] != '\u0000' && below[right] != '.' && !Character.isDigit(below[right])){
                return true;
            }
            
        }

        // up 
        if(above[i] != '\u0000' && above[i] != '.' && !Character.isDigit(above[i])) {
            return true;
        }

        // below
        if(below[i] != '\u0000' && below[i] != '.' && !Character.isDigit(below[i])) {
            return true;
        }

        return false;
    }
}