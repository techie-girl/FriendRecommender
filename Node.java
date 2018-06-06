import java.util.ArrayList;
/*
Creating funtions that will be called through the program.
*/
public class Node {
	private String name; 
	private ArrayList<Node> neighbours;
	//creating the constructor class 
	public Node (String s) {
		name= s;
		// creating the arraylist to store the friends of the values. 
		neighbours= new ArrayList(); 
	}
	public String getName() {
		return name;
	}
	//getting values from the arraylist. 
	public ArrayList<Node> getNeighbours() {
		return neighbours;
	}
	//adding a new value to the arraylist.
	public void addNeighbour(Node n) {
		neighbours.add(n);
	}

	
}
	