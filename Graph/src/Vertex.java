/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import heap.HeapElt;
import java.util.ArrayList;

/**
 *
 * @author lftomazini
 */
class Vertex extends HeapElt {

    private String key;
    private int index;
    private ArrayList<Edge> edges;
    private int predecessor;

    Vertex(String word, int index, ArrayList<Edge> neighbours) {
        this.key = word;
        this.index = index;
        this.edges = neighbours;
        this.predecessor = -1;
        this.record = -1;
    }

    public String getKey() {
        return key;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getPredecessor() {
        return predecessor;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void setPredecessor(int predecessor) {
        this.predecessor = predecessor;
    }

    void addEdge(Edge edge) {
        edges.add(edge);
    }
}
