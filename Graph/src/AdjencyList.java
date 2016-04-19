/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author lftomazini
 */
public class AdjencyList {
    //TODO make it private
    public ArrayList<Vertex> adjList;

    public AdjencyList() {
        this.adjList = new ArrayList<Vertex>();
    }

    public void addNode(String key) {
        int index = this.adjList.size();
        ArrayList<Edge> neighbours = findNeighbours(key, index);
        Vertex vertex = new Vertex(key, index, neighbours);
        this.adjList.add(vertex);
    }

    public ArrayList<Edge> findNeighbours(String key, int index) {
        ArrayList<Edge> neighbours = new ArrayList<Edge>();

        for (int i = 0; i < this.adjList.size(); i++) {
            Vertex newVertex = this.adjList.get(i);
            int transformations = numberOfTransformations(newVertex.getKey(),
                                                          key);
            if (transformations <= 2) {
                int weight = (transformations == 1) ? 1 : 5;
                newVertex.addEdge(new Edge(index, weight));
                neighbours.add(new Edge(i, weight));
            }
        }
        return neighbours;
    }

    public int searchHandle(String key) {
        for (int i = 0; i < this.adjList.size(); i++) {
            if (key.equalsIgnoreCase(this.adjList.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }

    public Vertex getVertex(int handle) {
        return this.adjList.get(handle);
    }

    private int numberOfTransformations(String key, String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void neighboursFromVertex(Vertex vertex) {
        for (int i = 0; i < vertex.getEdges().size(); i++) {
            int handle = vertex.getEdges().get(i).getDestinationIndex();
            String key = adjList.get(handle).getKey();
            int weight = vertex.getEdges().get(i).getWeight();
            System.out.println(key + " (" + weight + ")  ");
            if (i % 6 == 0) {
                System.out.println("\n");
            }
        }
    }
}
