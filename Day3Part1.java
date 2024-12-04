import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day3Input.txt");
        System.out.println(fileData);
        for (int i = 0; i < fileData.size(); i++) {
            String[] newString = fileData.get(i).split("mul\\(");
            for (int j = 0; j < newString.length; j++) {
                String line = newString[j];
                System.out.println(line);
                char letter = line.charAt(0);
                int count = 0;
                while (Character.isDigit(letter) || letter == 44 || letter == 41) {
                    if(letter == 41) {
                        // if )
                    }
                    count++;
                    System.out.println(letter);
                    letter =  line.charAt(count);
                }
                System.out.println("-end-");
            }

        }
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