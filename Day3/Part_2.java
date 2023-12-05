package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Part_2 {
    private static int maxx;
    private static int maxy = 0;

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        Map<Integer, Integer> numbers = new HashMap<>();
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int numberCount = 0;
            ArrayList<String> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                List<Integer> row = new ArrayList<>();
                char[] chars = line.toCharArray();
                for (char c : chars) {
                    row.add(isGear(c) ? -1 : 0);
                }
                maxx = row.size();
                matrix.add(row);
                rows.add(line);
                maxy++;
            }

            int sum = 0;
            for (int y = 0; y < maxy; y++) {
                line = rows.get(y);
                for (int x = 0; x < line.length(); x++) {
                    String number = "";
                    int startx = x;
                    while (x < maxx && isNumber(line.charAt(x))) {
                        number += line.charAt(x);
                        x++;
                    }

                    int endx = x - 1;

                    if (!number.isBlank()) {
                        numberCount++;
                        numbers.put(numberCount, Integer.parseInt(number));
                        for (int i = startx; i <= endx; i++) {
                            matrix.get(y).set(i, numberCount);
                        }
                    }
                }
            }

            for (int x = 0; x < maxx; x++) {
                for (int y = 0; y < maxy; y++) {
                    if (matrix.get(y).get(x) == -1) {
                        Set<Integer> an = isAdiacente(matrix, x, y);
                        if (an.size() == 2) {
                            Iterator<Integer> it = an.iterator();
                            int v = it.next();
                            int w = it.next();
                            sum += numbers.get(v) * numbers.get(w);
                        }
                    }
                }
            }

            writer.write(String.valueOf(sum));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    private static Set<Integer> isAdiacente(List<List<Integer>> matrix, int x, int y) {

        Set<Integer> numbers = new HashSet<>();

        if (x > 0) {
            if (get(matrix, x - 1, y) > 0) {
                numbers.add(get(matrix, x - 1, y));
            }
            if (y > 0 && get(matrix, x - 1, y - 1) > 0) {
                numbers.add(get(matrix, x - 1, y - 1));
            }
            if (y < maxy - 1 && get(matrix, x - 1, y + 1) > 0) {
                numbers.add(get(matrix, x - 1, y + 1));
            }
        }

        if (x < maxx - 1) {
            if (get(matrix, x + 1, y) > 0) {
                numbers.add(get(matrix, x + 1, y));
            }
            if (y > 0 && get(matrix, x + 1, y - 1) > 0) {
                numbers.add(get(matrix, x + 1, y - 1));
            }
            if (y < maxy - 1 && get(matrix, x + 1, y + 1) > 0) {
                numbers.add(get(matrix, x + 1, y + 1));
            }
        }

        if (y > 0) {
            if (get(matrix, x, y - 1) > 0) {
                numbers.add(get(matrix, x, y - 1));
            }
        }
        if (y < maxy - 1) {
            if (get(matrix, x, y + 1) > 0) {
                numbers.add(get(matrix, x, y + 1));
            }
        }

        return numbers;

    }

    private static int get(List<List<Integer>> matrix, int x, int y) {
        return matrix.get(y).get(x);
    }

    private static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isGear(char c) {
        if (c == '*') {
            return true;
        } else {
            return false;
        }
    }
}
