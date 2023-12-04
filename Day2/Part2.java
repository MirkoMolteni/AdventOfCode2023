package Day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                // Game 1: 3 blue, 7 green, 10 red; 4 green, 4 red; 1 green, 7 blue, 5 red; 8
                // blue, 10 red; 7 blue, 19 red, 1 green
                String[] games = line.split(": ")[1].split("; ");
                int maxRed = 0;
                int maxGreen = 0;
                int maxBlue = 0;
                for (String s1 : games) {
                    String[] game = s1.split(", ");
                    for (String s : game) {
                        String[] val = s.split(" ");
                        int num = Integer.parseInt(val[0]);
                        switch (val[1]) {
                            case "red":
                                if (num > maxRed) {
                                    maxRed = num;
                                }
                                break;
                            case "green":
                                if (num > maxGreen) {
                                    maxGreen = num;
                                }
                                break;
                            case "blue":
                                if (num > maxBlue) {
                                    maxBlue = num;
                                }
                                break;
                        }
                    }
                }

                sum += maxRed * maxGreen * maxBlue;
            }
            writer.write(String.valueOf(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
