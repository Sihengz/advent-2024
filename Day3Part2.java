import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day3Input.txt");
        System.out.println(fileData);
        boolean dothis = true;
        int total = 0;
        for (String fileDatum : fileData) {
            String[] newString = fileDatum.split("mul\\(|do");
            for (String line : newString) {
                System.out.println(line);
                char letter = line.charAt(0);
                int count = 0;
                String dig1 = "";
                String dig2 = "";
                boolean nextDigit = false;
                while (Character.isDigit(letter) || letter == 44) {
                    if (letter == 44) {
                        // if ,
                        nextDigit = true;
                    }
                    if (Character.isDigit(letter)) {
                        // if number
                        if (nextDigit) {
                            dig1 += letter;
                        } else {
                            dig2 += letter;
                        }
                    }
                    count++;
                    letter = line.charAt(count);
                }
                if (letter == 41 && dothis) {
                    // if )
                    System.out.println("valid: " + line);
                    System.out.println(Integer.parseInt(dig1) + Integer.parseInt(dig2));
                    total += Integer.parseInt(dig1) * Integer.parseInt(dig2);
                    dig1 = "";
                    dig2 = "";
                } else if (line.startsWith("()")) {
                    dothis = true;
                } else if (line.startsWith("n't()")) {
                    dothis = false;
                } else {
                    System.out.println("not valid" + line);
                }
                System.out.println("-end-");
                nextDigit = false;
            }
        }
        System.out.println(total);
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