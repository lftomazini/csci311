// Directory.java
// CSCI 311
// phone directory program
// CHANGE THIS PROGRAM ONLY WHERE INDICATED IN THE SWITCH STATEMENT
package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Directory {

    public static void main(String[] args) {

        BST<String> directory = new BST<String>();
        char code;
        String name, temp;
        Scanner in;

//        if (args.length != 1) {
//            System.err.println("Usage:  java Directory fileName");
//            System.exit(1);
//        }
        try {
            in = new Scanner(new BufferedReader(new FileReader(
                    "src/tree/input.dat.txt")));
            while (in.hasNext()) {
                temp = in.next();
                if (temp.length() > 1) {
                    System.err.println("ERROR IN INPUT.  TERMINATING");
                    System.exit(1);
                }
                code = temp.charAt(0);
                name = in.next();

                switch (code) {
                    case 'A':
                    case 'a': {
                        directory.Insert(name);
                        break;
                    }
                    case 'R':
                    case 'r': {

                        // ADD CODE FOR REMOVAL CASE HERE
                        break;
                    }
                    default:
                        System.err.println("Invalid code: " + code);
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Directory: Error opening file.");
            System.exit(1);
        }

        System.out.println("\n\nDirectory\n---------");
        directory.Print();
        System.out.println();

    }

}
