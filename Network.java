import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Network {

  private HashMap<String, Node> network;
/*
creating the consructor class, to implement join, leave, fried, unfriend.
*/
  public Network() {
    network = new HashMap<String, Node>();
  }

  public void join(String s) {
    network.put(s, new Node(s));
    System.out.println(s + " joined!");
  }

  public void leave(String s) {
    Node n = network.get(s);

    while (!n.getNeighbours().isEmpty()) {
      unfriend(s, n.getNeighbours().get(0).getName());
    }
    network.remove(n.getName());
    System.out.println(s + " left!");
  }

  public void unfriend(String s1, String s2) {
    //if statement to see if value is not there. and returning a statement against it. 
    if (!network.containsKey(s1)) {
      System.out.println("Network does not contain s1: --" + s1 + "--");
    }
    if (!network.containsKey(s2)) {
      System.out.println("Network does not contain s2: --" + s2 + "--");
    }
    Node n1 = network.get(s1);
    Node n2 = network.get(s2);
    n1.getNeighbours().remove(n2);
    n2.getNeighbours().remove(n1);
    System.out.println(s1 + " and " + s2 + " are unfriended!");
  }

  public ArrayList<String> friend(String s1, String s2) {
    //if statement to see if value is not there. and returning a statement against it. 
    if (!network.containsKey(s1)) {
      System.out.println("Network does not contain: --" + s1 + "--");
    }
    if (!network.containsKey(s2)) {
      System.out.println("Network does not contain: --" + s2 + "--");
    }
    /* creating the recomment fuction to be able to recoomend friends. 
    If B and A are friends then we recommend that the friends of A should be friends 
    with B and vise versa. 
    */
    ArrayList<String> result = reccommend(s1, s2);
    Node n1 = network.get(s1);
    Node n2 = network.get(s2);
    n1.addNeighbour(n2);
    n2.addNeighbour(n1);
    System.out.println(s1 + " and " + s2 + " are friended!");
    return result;
  }

  private ArrayList<String> reccommend(String s1, String s2) {
    ArrayList<String> result = new ArrayList<>();
    for (Node neighbour : network.get(s1).getNeighbours()) {
      if(!isFriend(s2,neighbour.getName())) {
        if (s2.compareTo(neighbour.getName()) < 0) {
          result.add(s2 + " and " + neighbour.getName() + " should be friends");
        } else {
          result.add(neighbour.getName() + " and " + s2 + " should be friends");
        }
      }
    }
    for (Node neighbour : network.get(s2).getNeighbours()) {
      if(!isFriend(s1,neighbour.getName())) {
        if (s1.compareTo(neighbour.getName()) < 0) {
          result.add(s1 + " and " + neighbour.getName() + " should be friends");
        } else {
          result.add(neighbour.getName() + " and " + s1 + " should be friends");
        }
      }
    }
    //sorting alphabetically
    result.sort((p1, p2) -> p1.compareTo(p2));
    return result;
  }
  // getting the friendship between the inpute variables. 
  private boolean isFriend(String s1, String s2) {
    return network.get(s1).getNeighbours().contains(network.get(s2)) && network.get(s2).getNeighbours().contains(network.get(s1));
  }
}