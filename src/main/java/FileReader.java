import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileReader {
    public void fileReader(String path){
//        File myObj = new File("input.txt");
//        try {
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String line = myReader.nextLine();
//                InputFilter.filter(line);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Error reading file");
//            e.printStackTrace();
//        }
        // new code below
        File myFile = new File(path);
//        System.out.println("myFile");
//        System.out.println(myFile);
        try (Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                InputFilter inputFilter = new InputFilter();
                inputFilter.filter(line);
//                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}
