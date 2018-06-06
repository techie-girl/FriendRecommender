import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Friend implements Tester {
/*
The compute function will be calling fuctions to implement the code. The purpose of the if 
stamtement is to check if the keywords are used in each input. -- using the split fuction. 
*/
  public ArrayList<String> compute(Scanner input) {
    Network n = new Network();
    ArrayList<String> result = new ArrayList<>();
    //
    while (input.hasNextLine()) {
      //check line by line as long as there is a next line.
      String line = input.nextLine();
      System.out.println(line);
      if(line.equals("end")){
        break;
      }
      else if (line.contains("joins")) {
        String name = line.split(" joins")[0];
        n.join(name);
      } else if (line.contains("unfriends")) {
        // getting value of A and B without the joining word in the middle.
        String name = line.split(" unfriends ")[0];
        String name2 = line.split(" unfriends ")[1];
        n.unfriend(name, name2);
      } else if (line.contains("friends")) {
        // getting value of A and B without the joining word in the middle.
        String name = line.split(" friends ")[0];
        String name2 = line.split(" friends ")[1];
        result.addAll(n.friend(name, name2));
      } else if (line.contains("leaves")) {
        String name = line.split(" leaves")[0];
        n.leave(name);

      }
    }

    return result;
  }
}