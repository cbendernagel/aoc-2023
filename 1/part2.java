import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Part2 {

    public static void main(String[] args) {
        try {
            File input = new File("./input.txt");
            Scanner reader = new Scanner(input);
            String strPattern = "^(one|two|three|four|five|six|seven|eight|nine|ten)";
            Pattern pattern = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            int sum = 0;
            int lineNum = 0;
            while(reader.hasNextLine()) {
                int first = -1, last = -1;
                String line = reader.nextLine();

                for(int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    if(Character.isDigit(character)) {
                        if(first == -1) {
                            first = character - '0';
                        }
                        last = character - '0';
                    } else {
                        // regex check
                        matcher = pattern.matcher(line.substring(i));
                        if(matcher.find()) {
                            int num = -1;
                            String results = matcher.group();
                            switch(results) {
                                case "zero":
                                    num = 0;
                                case "one":
                                    num = 1;
                                    break;
                                case "two":
                                    num = 2;
                                    break;
                                case "three":
                                    num = 3;
                                    break;
                                case "four":
                                    num = 4;
                                    break;
                                case "five":
                                    num = 5;
                                    break;
                                case "six":
                                    num = 6;
                                    break;
                                case "seven":
                                    num = 7;
                                    break;
                                case "eight":
                                    num = 8;
                                    break;
                                case "nine":
                                    num = 9;
                                    break;
                            }
                            if(num > -1){
                                if(first == -1) {
                                    first = num;
                                }
                                last = num;
                            }
                        }
                    }
                }

                lineNum = ((first * 10) + last);
                sum += lineNum;
            }
            
            System.out.println(sum);
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
            e.printStackTrace();
        }

    }

}
