package Day4;

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
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                int partialSum = 0;
                System.out.println(line);
                boolean first = true;
                line = line.replace("  ", " ");
                String numbers = line.split(": ")[1];
                String[] winningNumbers = numbers.split("\\| ")[0].split(" ");
                String[] myNumbers = numbers.split("\\| ")[1].split(" ");
                for (String mn : myNumbers) {
                    for (String wn : winningNumbers) {
                        if (wn.equals(mn))
                            if (first) {
                                partialSum += 1;
                                first = false;
                            } else {
                                partialSum *= 2;
                            }
                    }
                }

                sum += partialSum;

            }
            writer.write(String.valueOf(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
