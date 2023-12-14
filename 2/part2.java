import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

class Part2 {

    public static void main(String[] args) {
        try {
            File input = new File("./input.txt");
            Scanner reader = new Scanner(input);

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("red", 0);
            map.put("green", 0);
            map.put("blue", 0);

            Pattern gamePat = Pattern.compile("^Game [0-9]*", Pattern.CASE_INSENSITIVE);
            Pattern colorPat = Pattern.compile("[0-9]* (red|green|blue)", Pattern.CASE_INSENSITIVE);
            Matcher matcher;

            int total = 0;
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                matcher = gamePat.matcher(line);
                if(matcher.find()) {
                    map.put("red", 0);
                    map.put("green", 0);
                    map.put("blue", 0);
                    // check all patterns on the line
                    matcher = colorPat.matcher(line);
                    while(matcher.find()) {
                        String[] play = matcher.group().split(" ");
                        int cubes = Integer.parseInt(play[0]);

                        if(cubes > map.get(play[1]))
                            map.put(play[1], cubes);
                    }

                    total += (map.get("red") * map.get("green") * map.get("blue"));
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
