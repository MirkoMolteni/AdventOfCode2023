package Day1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Part_1 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                numbers = new ArrayList<Integer>();
                System.out.println(line);
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        System.out.print(c + " ");
                        numbers.add(Character.getNumericValue(c));
                    }
                }
                int num = (numbers.get(0) * 10) + numbers.get(numbers.size() - 1);
                sum += num;
                System.out.println(num);
            }
            writer.write(Integer.toString(sum));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}