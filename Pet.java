import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class pet{//Id Name Type Gender ZipCode
     String id;
     String name;
     String type;
     String gender;
     String zipcode;
    public pet(String id, String name, String type, String gender, String zipcode){
        this.id = id;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.zipcode = zipcode;
    }

    public static String finalString(pet p){
        return p.id + " " +p.name + " " + p.type + " " + p.gender +" " + p.zipcode;
    }

    public static boolean matching(String types, String content, pet p){
        switch(types){
            case "id": 
                if((p.id).equals(content)){
                    return true;
                }
                return false;
            case "name": 
                if((p.name.toLowerCase()).equals(content)){
                    return true;
                }
                return false;
            case "type": 
                if((p.type.toLowerCase()).equals(content)){
                    return true;
                }
                return false;
            case "gender": 
                if((p.gender.toLowerCase()).equals(content)){
                    return true;
                }
                return false;
            case "zipcode": 
                if((p.zipcode).equals(content)){
                    return true;
                }
                return false;
            default:
                System.out.println("Please retry. Incorrect format.");
                return false;
        }
    }

    
    public static void main(String[] args) {
        if (args == null) {
          System.out.println("Please use correct format: main.java filename.txt");
        }
        Scanner scan = new Scanner(System.in);
        String search;
        do {
          System.out.println(
            "Please enter the search by Name, Type, Gender, ZipCode. (ex. ZipCode 01234)"
          );
          search = scan.nextLine();
        } while (search.isEmpty() == true);
        ArrayList <pet> pets = new ArrayList<pet>();
    
        try {
              File data_file = new File(args[0]);
              Scanner myReader = new Scanner(data_file);
        
              while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] d2 = data.split(" ");
                pets.add(new pet(d2[0], d2[1], d2[2], d2[3], d2[4])); 
              }
              myReader.close();
            } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        String [] param = search.split(" ");
        ArrayList <pet> double_search = new ArrayList<pet>();

        for(pet p: pets){
            if(matching(param[0].toLowerCase(),param[1].toLowerCase(),p)){
                if(param.length > 2){
                    double_search.add(p);
                }
                else{
                    System.out.println(finalString(p));
                }
            }
        }
        if(param.length > 2){
            for(pet p: pets){
                if(matching(param[2].toLowerCase(),param[3].toLowerCase(),p)){
                    System.out.println(finalString(p));
                }
            }
        }

      }
}
