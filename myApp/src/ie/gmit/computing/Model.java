package ie.gmit.computing;

/**
 * Initializing the first node
 * @author Ethan
 *
 */
public class Model {

	/**
	 * Constructor
	 */
	public Model(){
		Node start=new Node("Start", null);
		Node.childrensName.add(start.getTitle());
		Node.map.put("Start", start);
		
		Node solid=new Node("solid", start);
		start.addNode(solid);
	}
}
