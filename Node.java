import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meirunas
 */
public class Node {

    private String name;
    private int x, y;

    private List<Node> shortestPath = new LinkedList<>();

    private double distance = Double.MAX_VALUE;

    Map<Node, Double> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, double distance) {
        adjacentNodes.put(destination, distance);
     //   System.out.println("source=" + name+ "dest=" + destination.getName());
    }

    public Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;

    }

    public Map<Node, Double> getAdjacentNodes() {
        return adjacentNodes;
    }

    public double getDistance() {
        return distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public String getName() {
        return name;
    }

    // getters and setters
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    public String returnShortestPath() {
        String output = "";
        for (int i = 0; i < shortestPath.size(); i++) {
            output += shortestPath.get(i).getName() + "->";

        }
        return output;
    }
}