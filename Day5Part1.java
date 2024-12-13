import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5Part1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day5Input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> pages = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).contains("|")) {
                rules.add(fileData.get(i));
            } else {
                pages.add(fileData.get(i));
            }
        }
        System.out.println(rules);
        System.out.println(pages);
        System.out.println(getDigits(pages.getFirst()));
        System.out.println(getRule(rules.getFirst()));

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

    public static ArrayList<Integer> getDigits(String line) {
        String[] digitStings = line.split(",");
        ArrayList<Integer> digits = new ArrayList<>();
        for (String digitSting : digitStings) {
            digits.add(Integer.parseInt(digitSting));
        }
        return digits;
    }

    public static ArrayList<Integer> getRule(String line) {
        String[] digitStings = line.split("\\|");
        ArrayList<Integer> digits = new ArrayList<>();
        for (String digitSting : digitStings) {
            digits.add(Integer.parseInt(digitSting));
        }
        return digits;
    }

    public static ArrayList<Integer> getCorrectList(ArrayList<String> rules) {
        ArrayList<Integer> correctList= new ArrayList<>();
        for (int i = 0; i < rules.size(); i++) {
            ArrayList<Integer> splitRule = getRule(rules.get(i));

        }
    }
}