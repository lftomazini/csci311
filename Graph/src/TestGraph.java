/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lftomazini
 */
public class TestGraph {
    static AdjencyList adjList = new AdjencyList();
    static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File inFile = new File(args[0]);
            Scanner in = new Scanner(inFile);
            Graph.constructGraph(inFile, adjList);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found." + e);
        }
        //neighbours();
        wordGame();
    }

    private static void neighbours() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Provide a five-letter word: ");
            String s = in.next().toUpperCase();
            int handle = adjList.searchHandle(s);
            printNeighbours(handle, s, adjList);
            repeat = repeat();
        }
    }

    private static void wordGame() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter the first five-letter word: ");
            String word1 = in.next().toUpperCase();
            int handle1 = adjList.searchHandle(word1);
            if (handle1 == -1) {
                System.out.println("Key " + word1 + " not found");
                continue;
            }
            System.out.println("Enter the second five-letter word: ");
            String word2 = in.next().toUpperCase();
            int handle2 = adjList.searchHandle(word2);
            if (handle2 == -1) {
                System.out.println("Key " + word2 + " not found");
                continue;
            }
            printBestScore(handle1, handle2);
            repeat = repeat();
        }
    }

    private static void printNeighbours(int handle, String s,
                                        AdjencyList adjList) {
        if (handle == -1) {
            System.out.println("Key " + s + " not found");
        } else {
            System.out.println("The neighbours from " + s + " are:\n");
            adjList.neighboursFromVertex(adjList.getVertex(handle));
        }
    }

    private static void printBestScore(int handle1, int handle2) {
        //System.out.println("The best score from " + " to " + " is " + " points");
        adjList.bestScoreSequence(handle1, handle2);
    }

    private static boolean repeat() {
        while (true) {
            System.out.println("Do you want to enter another word?");
            String option = in.next().toUpperCase();

            if (option.equals("NO") || option.equals("N")) {
                return false;
            }

            if (option.equals("YES") || option.equals("Y")) {
                return true;
            }
            System.out.println(
                    "Invalid option. Answer with \"yes\" or \"y\" or \"no\" or \"n\".");
        }
    }
}
