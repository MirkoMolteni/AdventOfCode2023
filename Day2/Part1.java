package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        final int MAX_BLUE = 14;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int sum = 0;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                // Game 1: 3 blue, 7 green, 10 red; 4 green, 4 red; 1 green, 7 blue, 5 red; 8
                // blue, 10 red; 7 blue, 19 red, 1 green
                String[] games = line.split(": ")[1].split("; ");
                boolean valid = true;
                for (String s1 : games) {
                    String[] game = s1.split(", ");
                    for (String s : game) {
                        String[] val = s.split(" ");
                        int num = Integer.parseInt(val[0]);
                        switch (val[1]) {
                            case "red":
                                if (num > MAX_RED) {
                                    valid = false;
                                }
                                break;
                            case "green":
                                if (num > MAX_GREEN) {
                                    valid = false;
                                }
                                break;
                            case "blue":
                                if (num > MAX_BLUE) {
                                    valid = false;
                                }
                                break;
                        }
                    }
                }

                if (valid) {
                    sum += count;
                }
                count++;
            }
            writer.write(String.valueOf(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
