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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        askUser();
    }

    private static void askUser() {
        AdjencyList adjList = new AdjencyList();
        try {
            // File inFile = new File(args[0]);
            File inFile = new File("src/wordList");
            Scanner in = new Scanner(inFile);
            Graph.constructGraph(inFile, adjList);

            boolean repeat = true;
            while (repeat) {
                System.out.println("Provide a five-letter word: ");
                String s = in.next().toUpperCase();
                int handle = adjList.searchHandle(s);
                printNeighbours(handle, s, adjList);
                repeat = repeat();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found." + e);
        }
    }

    private static void printNeighbours(int handle, String s,
                                        AdjencyList adjList) {
        if (handle == -1) {
            System.out.println("Key " + s + " not found");
        } else {
            System.out.println("The keighbours from " + s + " are:\n");
            adjList.neighboursFromVertex(adjList.getVertex(handle));
        }
    }

    private static boolean repeat() {
        while (true) {
            System.out.println("Do you want to enter another word?");
            Scanner in = new Scanner(System.in);
            String option = in.next().toUpperCase();

            if (option.equals("NO") || option.equals("N")) {
                return false;
            }

            if (option.equals("YES") || option.equals("Y")) {
                return true;
            }
            System.out.println("Invalid option. Answer with \"yes\" or \"no\"");
        }
    }
}
