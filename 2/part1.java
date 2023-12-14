import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;

class Part1 {

    public static void main(String[] args) {
        try {
            File input = new File("./input.txt");
            Scanner reader = new Scanner(input);

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("red", 12);
            map.put("green", 13);
            map.put("blue", 14);

            Pattern gamePat = Pattern.compile("^Game [0-9]*", Pattern.CASE_INSENSITIVE);
            Pattern colorPat = Pattern.compile("[0-9]* (red|green|blue)", Pattern.CASE_INSENSITIVE);
            Matcher matcher;

            int total = 0;
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

                        if(Integer.parseInt(play[0]) > map.get(play[1]))
                            validGame = false;
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
