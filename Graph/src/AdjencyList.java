/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import heap.Heap;
import java.util.ArrayList;

/**
 *
 * @author lftomazini
 */
public class AdjencyList {
    private ArrayList<Vertex> adjList;

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

    private int numberOfTransformations(String str1, String str2) {
        int transformations = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                transformations++;
            }
        }
        return transformations;
    }

    void neighboursFromVertex(Vertex vertex) {
        for (int i = 0; i < vertex.getEdges().size(); i++) {
            int handle = vertex.getEdges().get(i).getDestinationIndex();
            String key = this.adjList.get(handle).getKey();
            int weight = vertex.getEdges().get(i).getWeight();
            System.out.print(key + " (" + weight + ")  ");
            if (i % 6 == 5) {
                System.out.print("\n");
            }
        }
        System.out.println("\n");
    }

    void dijkstrasAlgorithm(int start) {
        Vertex initial = this.adjList.get(start);

        //initialize graph
        Vertex vertex;
        for (int i = 0; i < this.adjList.size(); i++) {
            vertex = this.adjList.get(i);
            vertex.setRecord(Integer.MAX_VALUE);
            vertex.setPredecessor(-1);
        }
        initial.setRecord(0);

        //intialize heap
        Heap heap = new Heap();
        heap.insert(initial);
        for (int i = 0; i < this.adjList.size(); i++) {
            if (initial.getIndex() != i) {
                heap.insert(this.adjList.get(i));
            }
        }

        //loop
        Vertex adjency;
        while (heap.getHeapsize() != 0) {
            try {
                vertex = (Vertex) heap.removeMin();
                for (Edge edge : vertex.getEdges()) {
                    adjency = getVertex(edge.getDestinationIndex());
                    if ((Integer) vertex.getRecord() + edge.getWeight() < (Integer) adjency.getRecord()) {
                        adjency.setPredecessor(vertex.getIndex());
                        adjency.setRecord(
                                (Integer) vertex.getRecord() + edge.getWeight());
                        heap.heapifyUp(adjency.getHandle());
                    }
                }
            } catch (Exception ex) {
                System.err.println("Heap is empty!");
            }
        }
    }

    void bestScoreSequence(int handle1, int handle2) {
        ArrayList<Integer> reversePath = findMinimumPath(handle1, handle2);
        System.out.println(
                "The best score from " + this.adjList.get(handle1).getKey() + " to " + adjList.get(
                        handle2).getKey() + " is " + getDistance(handle2) + " points:\n");
        printSequence(reversePath);
    }

    private ArrayList<Integer> findMinimumPath(int handle1, int handle2) {
        dijkstrasAlgorithm(handle1);
        return findReversePath(this.adjList.get(handle1), this.adjList.get(
                               handle2),
                               new ArrayList<Integer>());
    }

    private int getDistance(int lastElement) {
        return (Integer) this.adjList.get(lastElement).getRecord();
    }

    private void printSequence(ArrayList<Integer> reversePath) {
        for (int i = reversePath.size() - 1; i >= 0; i--) {
            System.out.print(this.adjList.get(reversePath.get(i)).getKey() + " ");
            if ((reversePath.size() - i) % 10 == 9) {
                System.out.print("\n");
            }
        }
        System.out.println("\n");
    }

    private ArrayList<Integer> findReversePath(Vertex initial, Vertex last,
                                               ArrayList<Integer> path) {
        if (initial.equals(last)) {
            path.add(last.getIndex());

            return path;
        } else {
            Vertex next = this.adjList.get(last.getPredecessor());
            path.add(last.getIndex());

            return findReversePath(initial, next, path);
        }
    }
}
