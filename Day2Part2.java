
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day2Input.txt");
        ArrayList<String[]> grid = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            grid.add(i, fileData.get(i).split(" "));
            System.out.println(Arrays.toString(grid.get(i)));
        }
        int safeTotal = 0;
        for (String[] strings : grid) {
            boolean safe = isSafe(strings, true);
            if (safe) {
                safeTotal++;
            }
        }
        System.out.println(safeTotal);

    }

    private static boolean isSafe(String[] strings, boolean tolerant) {
        int lastNumber = Integer.parseInt(strings[0]);
        boolean increasing = lastNumber < Integer.parseInt(strings[1]);
        boolean safe = true;
        for (int j = 1; j < strings.length; j++) {
            int currentNumber = Integer.parseInt(strings[j]);
            int diff = Math.abs(lastNumber - currentNumber);
            if (increasing && lastNumber > currentNumber) { // consistent
                if (tolerant) {
                    safe = CheckAll(strings);
                    return safe;
                } else {
                    safe = false;
                }
            } else if (!increasing && lastNumber < currentNumber) {
                if (tolerant) {
                    safe = CheckAll(strings);
                    return safe;
                } else {
                    safe = false;
                }
            } else if (diff > 3 || diff < 1) {
                if (tolerant) {
                    safe = CheckAll(strings);
                    return safe;
                } else {
                    safe = false;
                }
            }
            lastNumber = Integer.parseInt(strings[j]);
        }
        return safe;
    }
    private static boolean CheckAll(String[] strings) {
        boolean safe;
        for (int i = 0; i < strings.length; i++) {
            safe = isSafe(removeIndex(strings, i), false);
            if (safe) {
                System.out.println("safe: " + Arrays.toString(removeIndex(strings, i)));
                return true;
            }
        }
        return false;
    }
    private static String[] removeIndex(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if(i < index) {
                newArray[i] = array[i];
            } else if(i > index){
                newArray[i-1] = array[i];
            }
        }
        return newArray;
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}