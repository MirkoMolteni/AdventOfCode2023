package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part_2 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            long sum = 1;
            int count = 0;
            long raceTime = 0;
            long raceDistance = 0;
            while ((line = reader.readLine()) != null) {
                String temp = line.split(":")[1];
                if (count == 0) {
                    raceTime = Long.parseLong(temp.replace(" ", ""));
                } else {
                    raceDistance = Long.parseLong(temp.replace(" ", ""));
                }
                count++;
            }

            long pressTime = 0;
            while (pressTime++ <= raceTime) {
                long time = raceTime - pressTime;
                long myDistance = time * pressTime;
                if (myDistance > raceDistance) {
                    System.out.println("Trovato: " + pressTime);
                    break;
                }
            }
            sum = raceTime - pressTime - pressTime + 1;
            writer.write(String.valueOf(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
