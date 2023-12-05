package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part_1 {
    private static int maxx;
    private static int maxy = 0;

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            ArrayList<String> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                List<Integer> row = new ArrayList<>();
                char[] chars = line.toCharArray();
                for (char c : chars) {
                    row.add(isSymbol(c) ? 1 : 0);
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
                        int value = Integer.parseInt(number);

                        if (isAdiacente(matrix, startx, endx, y)) {
                            sum += value;
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

    private static boolean isAdiacente(List<List<Integer>> matrix, int startx, int endx, int y) {

        if (startx > 0) {
            if (get(matrix, startx - 1, y)) {
                return true;
            }
            if (y > 0 && get(matrix, startx - 1, y - 1)) {
                return true;
            }
            if (y < maxy - 1 && get(matrix, startx - 1, y + 1)) {
                return true;
            }
        }

        if (endx < maxx - 1) {
            if (get(matrix, endx + 1, y)) {
                return true;
            }
            if (y > 0 && get(matrix, endx + 1, y - 1)) {
                return true;
            }
            if (y < maxy - 1 && get(matrix, endx + 1, y + 1)) {
                return true;
            }
        }

        if (y > 0) {
            for (int x = startx; x <= endx; x++) {
                if (get(matrix, x, y - 1)) {
                    return true;
                }
            }
        }
        if (y < maxy - 1) {
            for (int x = startx; x <= endx; x++) {
                if (get(matrix, x, y + 1)) {
                    return true;
                }
            }
        }

        return false;

    }

    private static boolean get(List<List<Integer>> matrix, int x, int y) {
        return matrix.get(y).get(x) == 1;
    }

    private static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isSymbol(char c) {
        if (c == '.' || (c >= '0' && c <= '9')) {
            return false;
        } else {
            return true;
        }

    }
}
