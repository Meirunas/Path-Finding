import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();
     
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
 
    public Set<Node> getNodes() {
    	return nodes;
    }

    public String returnShortestPathToEnd(Node endNode) {
    	String output = "Path = " + endNode.returnShortestPath() + endNode.getName()
    			+ "\nDistance=" + endNode.getDistance();
    	return output;
    }

    /*@Override
    public String toString() {
    	String output = "";
    	for(Node node: nodes)
    		output += node.getName() + "-";
    	return output;
    }*/
}