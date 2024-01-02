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

            int total = 0;
            int redMin, blueMin, greenMin;

            Pattern gamePat = Pattern.compile("^Game [0-9]*", Pattern.CASE_INSENSITIVE);
            Pattern colorPat = Pattern.compile("[0-9]* (red|green|blue)", Pattern.CASE_INSENSITIVE);
            Matcher matcher;

            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                matcher = gamePat.matcher(line);
                if(matcher.find()) {
                    int gameNumber = Integer.parseInt(matcher.group().split(" ")[1]);
                    redMin = 0;
                    blueMin = 0;
                    greenMin = 0;
                    // check all patterns on the line
                    matcher = colorPat.matcher(line);
                    while(matcher.find()) {
                        String[] play = matcher.group().split(" ");
                        int cubes = Integer.parseInt(play[0]);
                        switch(play[1]){
                            case "red":
                                if(cubes > redMin) {
                                    redMin = cubes;
                                }
                                break;
                            case "green":
                                if(cubes > greenMin) {
                                    greenMin = cubes;
                                }
                                break;
                            case "blue":
                                if(cubes > blueMin) {
                                    blueMin = cubes;
                                }
                                break;
                        }
                    }

                    System.out.println(gameNumber + ": " + redMin + "-" +greenMin + "-" + blueMin);
                    total += (redMin * greenMin * blueMin);
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
