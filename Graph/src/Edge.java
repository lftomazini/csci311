/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lftomazini
 */
class Edge {
    private int destinationIndex;
    private int weight;

    public Edge(int destinationIndex, int weight) {
        this.destinationIndex = destinationIndex;
        this.weight = weight;
    }

    public int getDestinationIndex() {
        return destinationIndex;
    }

    public int getWeight() {
        return weight;
    }

}
