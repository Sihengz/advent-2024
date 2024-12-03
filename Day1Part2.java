import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day1Input.txt");
        System.out.println(fileData);
        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();
        for (String fileDatum : fileData) {
            String[] ids = fileDatum.split(" ");
            int idOne = Integer.parseInt(ids[0]);
            int idTwo = Integer.parseInt(ids[3]);
            listOne.add(idOne);
            listTwo.add(idTwo);
        }
        listOne.sort(null);
        listTwo.sort(null);
        int total = 0;
        for (int id1 : listOne) {
            for (int id2 : listTwo) {
                if (id1 == id2) {
                    total+=id1;
                }
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