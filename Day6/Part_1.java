package Day6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part_1 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int sum = 1;
            int count = 0;
            int[] times = new int[4];
            int[] distance = new int[4];
            while ((line = reader.readLine()) != null) {
                String temp = line.split(":")[1];
                if (count == 0) {
                    temp = temp.replace("        ", "");
                    temp = temp.replace("     ", " ");
                    times[0] = Integer.parseInt(temp.split(" ")[0]);
                    times[1] = Integer.parseInt(temp.split(" ")[1]);
                    times[2] = Integer.parseInt(temp.split(" ")[2]);
                    times[3] = Integer.parseInt(temp.split(" ")[3]);
                } else {
                    temp = temp.replace("   ", " ");
                    distance[0] = Integer.parseInt(temp.split(" ")[1]);
                    distance[1] = Integer.parseInt(temp.split(" ")[2]);
                    distance[2] = Integer.parseInt(temp.split(" ")[3]);
                    distance[3] = Integer.parseInt(temp.split(" ")[4]);
                }
                count++;
            }

            for (int raceIndex = 0; raceIndex < 4; raceIndex++) {
                int partialSum = 0;
                System.out.println(times[raceIndex] + " - " + distance[raceIndex]);
                for (int pressTime = 0; pressTime <= times[raceIndex]; pressTime++) {
                    int time = times[raceIndex] - pressTime;
                    int myDistance = time * pressTime;
                    if (myDistance > distance[raceIndex]) {
                        System.out.println("Trovato: " + pressTime + " - " + myDistance);
                        partialSum++;
                    }
                }
                System.out.println("Tentativi corretti: " + partialSum);
                sum = sum * partialSum;
            }
            writer.write(String.valueOf(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
