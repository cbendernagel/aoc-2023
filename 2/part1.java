import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Part1 {

    public static void main(String[] args) {
        try {
            File input = new File("./input.txt");
            Scanner reader = new Scanner(input);

            int redMax = 12, greenMax = 13, blueMax = 14, total = 0;

            Pattern gamePat = Pattern.compile("^Game [0-9]*", Pattern.CASE_INSENSITIVE);
            Pattern colorPat = Pattern.compile("[0-9]* (red|green|blue)", Pattern.CASE_INSENSITIVE);
            Matcher matcher;

            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                matcher = gamePat.matcher(line);
                if(matcher.find()) {
                    int gameNumber = Integer.parseInt(matcher.group().split(" ")[1]);
                    boolean validGame = true;
                    // check all patterns on the line
                    matcher = colorPat.matcher(line);
                    while(matcher.find()) {
                        String[] play = matcher.group().split(" ");
                        switch(play[1]){
                            case "red":
                                if(Integer.parseInt(play[0]) > redMax) {
                                    validGame = false;
                                }
                                break;
                            case "green":
                                if(Integer.parseInt(play[0]) > greenMax) {
                                    validGame = false;
                                }
                                break;
                            case "blue":
                                if(Integer.parseInt(play[0]) > blueMax) {
                                    validGame = false;
                                }
                                break;
                        }
                    }

                    if(validGame)
                        total += gameNumber;
                }
            }

            reader.close();

            System.out.println(total);
        }
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
            e.printStackTrace();
        }

    }

}
