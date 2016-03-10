
/**
 * A class to test hash function variations Requires two integers to be provided
 * on the command line
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHash {

    public static void main(String[] args) {

        try {
            //int radix = Integer.parseInt(args[0]);
            //int modulus = Integer.parseInt(args[1]);
            //File inFile = new File(args[2]);
            int radix = 128;
            int modulus = 97;
            File inFile = new File("src/wordList");
            Scanner in = new Scanner(inFile);
            String inStr;
            int[] hashValues = new int[modulus];

            System.out.println();
            System.out.println("Using radix " + radix + " and modulus "
                               + modulus
                               + ".");
            System.out.println();
            System.out.println("  Input  |  hash value");
            System.out.println("----------------------");

            int hash;
            while (in.hasNext()) {
                inStr = in.next();
                hash = Hash.hash(inStr, radix, modulus);
                System.out.printf("%7s  |%8d\n", inStr, hash);
                hashValues[hash]++;
            }

            System.out.println("\n");

            for (int i = 0; i < hashValues.length; i++) {
                System.out.print(hashValues[i] + ",");
            }
            System.out.println("\n");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found." + e);
        }
    }
}
