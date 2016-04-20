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
public class Graph {

    public static void constructGraph(File file, AdjencyList adjList) {
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                adjList.addNode(in.next());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found." + e);
        }
    }

}
