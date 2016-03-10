
/**
 * An implementation of a hash function
 */
public class Hash {

    /*
     NOTE that the indexing of the characters in a Java string is reversed
     from what we used in lecture.
     */
    public static int hash(String inStr, int radix, int modulus) {
        int h = 0;
        for (int i = 0; i < inStr.length(); i++) {
            h = ((h * radix + (int) inStr.charAt(i)) % modulus);
        }

        return h;
    }
}
