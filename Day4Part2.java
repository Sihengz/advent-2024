import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day4Input.txt");
        System.out.println(fileData);
        int rows = fileData.size();
        int columns = fileData.getFirst().length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
                System.out.print(grid[r][c]);

            }
            System.out.println();
        }
        int total = 0;
        for (int r = 0; r < grid.length - 2; r++) {
            for (int c = 0; c < grid[0].length - 2; c++) {
                System.out.println(r + " " + c);
                if (checkLeft(grid, r, c)) {
                    total++;
                }
                if (checkRight(grid, r, c)) {
                    total++;
                }
                if (checkUp(grid, r, c)) {
                    total++;
                }
                if (checkDown(grid, r, c)) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }

    public static boolean checkLeft(String[][] grid, int row, int col) {
        System.out.println(grid[row][col]);
        return grid[row][col].equals("M") && grid[row + 2][col].equals("M") &&
                grid[row + 1][col + 1].equals("A") && grid[row][col + 2].equals("S") && grid[row + 2][col + 2].equals("S");
    }
    public static boolean checkRight(String[][] grid, int row, int col) {
        return grid[row][col].equals("S") && grid[row + 2][col].equals("S") &&
                grid[row + 1][col + 1].equals("A") && grid[row][col + 2].equals("M") && grid[row + 2][col + 2].equals("M");
    }
    public static boolean checkUp(String[][] grid, int row, int col) {
        return grid[row][col].equals("S") && grid[row + 2][col].equals("M") &&
            grid[row + 1][col + 1].equals("A") && grid[row][col + 2].equals("S") && grid[row + 2][col + 2].equals("M");
    }
    public static boolean checkDown(String[][] grid, int row, int col) {
        return grid[row][col].equals("M") && grid[row + 2][col].equals("S") &&
                grid[row + 1][col + 1].equals("A") && grid[row][col + 2].equals("M") && grid[row + 2][col + 2].equals("S");
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