import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day4Input.txt");
        System.out.println(fileData);
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
                System.out.print(grid[r][c]);

            }
            System.out.println();
        }
        int total = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (checkLeft(grid, r, c)) {;
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
        return col + 2 >= 0 && row + 2 >= 0 && grid[row][col].equals("M") && grid[row + 2][col].equals("M") && grid[row + 1][col + 1].equals("A") && grid[row][col + 2].equals("S") && grid[row + 2][col + 2].equals("S")
    }
    public static boolean checkRight(String[][] grid, int row, int col) {
        return col + 3 < grid.length && grid[row][col].equals("X") && grid[row][col + 1].equals("M") && grid[row][col + 2].equals("A") && grid[row][col + 3].equals("S");
    }
    public static boolean checkUp(String[][] grid, int row, int col) {
        return row - 3 >= 0 && grid[row][col].equals("X") && grid[row - 1][col].equals("M") && grid[row - 2][col].equals("A") && grid[row - 3][col].equals("S");
    }
    public static boolean checkDown(String[][] grid, int row, int col) {
        return row + 3 < grid.length && grid[row][col].equals("X") && grid[row + 1][col].equals("M") && grid[row + 2][col].equals("A") && grid[row + 3][col].equals("S");
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