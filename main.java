import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    if (args == null) {
      System.out.println("Please use correct format: main.java filename.txt");
    }
    Scanner scan = new Scanner(System.in);
    String search;
    do {
      System.out.println(
        "Please enter the search by Name, Type, Gender, ZipCode. (ex. ZipCode 01234 or Gender Male Type Cat)"
      );
      search = scan.nextLine();
    } while (search.isEmpty() == true);
    ArrayList pets = new ArrayList();

    try {
          File data_file = new File(args[0]);
          Scanner myReader = new Scanner(data_file);
    
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String [] d2 = data.split(" ");
            pets.add(new Pet(d2[0], d2[1], d2[2], d2[3], d2[4])); 
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    for(Pet e: pets){
        System.out.println(e);

    }
  }
}
