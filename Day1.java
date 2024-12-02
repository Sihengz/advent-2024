import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        System.out.println(fileData);
        ArrayList<Integer> listOne = new ArrayList<Integer>();
        ArrayList<Integer> listTwo = new ArrayList<Integer>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] ids = fileData.get(i).split(" ");
            int idOne = Integer.parseInt(ids[0]);
            int idTwo = Integer.parseInt(ids[3]);
            listOne.add(idOne);
            listTwo.add(idTwo);
        }
        listOne.sort(null);
        listTwo.sort(null);
        while (!listOne.isEmpty()) {

        }

        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}