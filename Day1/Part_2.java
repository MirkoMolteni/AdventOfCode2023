package Day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Part_2 {
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
                int pos = 0;
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        numbers.add(Character.getNumericValue(c));
                    } else {
                        switch (line.charAt(pos)) {
                            case 'o':
                                // one
                                if (pos + 3 <= line.length() && line.substring(pos, pos + 3).equals("one")) {
                                    numbers.add(1);
                                }
                                break;
                            case 't':
                                // two, three
                                if (pos + 3 <= line.length() && line.substring(pos, pos + 3).equals("two")) {
                                    numbers.add(2);
                                } else if (pos + 5 <= line.length() && line.substring(pos, pos + 5).equals("three")) {
                                    numbers.add(3);
                                }
                                break;
                            case 'f':
                                // four, five
                                if (pos + 4 <= line.length() && line.substring(pos, pos + 4).equals("four")) {
                                    numbers.add(4);
                                } else if (pos + 4 <= line.length() && line.substring(pos, pos + 4).equals("five")) {
                                    numbers.add(5);
                                }
                                break;
                            case 's':
                                // six, seven
                                if (pos + 3 <= line.length() && line.substring(pos, pos + 3).equals("six")) {
                                    numbers.add(6);
                                } else if (pos + 5 <= line.length() && line.substring(pos, pos + 5).equals("seven")) {
                                    numbers.add(7);
                                }
                                break;
                            case 'e':
                                // eight
                                if (pos + 5 <= line.length() && line.substring(pos, pos + 5).equals("eight")) {
                                    numbers.add(8);
                                }
                                break;
                            case 'n':
                                // nine
                                if (pos + 4 <= line.length() && line.substring(pos, pos + 4).equals("nine")) {
                                    numbers.add(9);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    pos++;
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
