package Day4;

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
            int sumCarte = 0;
            int[] countCards = new int[223];
            for (int i = 0; i < countCards.length; i++) {
                countCards[i] = 1;
            }
            int righe = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                line = line.replace("  ", " ");
                String numbers = line.split(": ")[1];
                String[] winningNumber = numbers.split("\\| ")[0].split(" ");
                String[] myNumbers = numbers.split("\\| ")[1].split(" ");
                for (int j = 0; j < countCards[righe - 1]; j++) {
                    int winningNumbers = 0;
                    for (String mn : myNumbers) {
                        for (String wn : winningNumber) {
                            if (wn.equals(mn))
                                winningNumbers++;
                        }
                    }
                    for (int i = righe; i < winningNumbers + righe; i++) {
                        countCards[i]++;
                    }
                }
                righe++;
            }

            for (int i = 0; i < countCards.length; i++) {
                System.out.println("Carta " + (i + 1) + ": " + countCards[i]);
                sumCarte += countCards[i];
            }

            writer.write(String.valueOf(sumCarte));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}