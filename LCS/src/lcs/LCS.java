/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

import java.util.HashSet;

/**
 *
 * @author lftomazini
 *
 * A top-down implementation of the longest common subsequence using memoization
 */
public class LCS {
    //Allocate and initialize array
    public int[][] memo;
    public String str1;
    public String str2;
    public static int i = 0;

    public LCS(String str1, String str2) {
        this.memo = new int[str1.length()][str2.length()];
        for (int i = 0; i < this.memo.length; i++) {
            for (int j = 0; j < this.memo[0].length; j++) {
                this.memo[i][j] = -1;
            }
        }
        this.str1 = str1;
        this.str2 = str2;
    }

    public int length(int n, int m) {
        if (n == this.str1.length() || m == this.str2.length()) {
            return 0;
        } else if (this.memo[n][m] == -1) {
            //Store values for future use
            if (str1.charAt(n) == str2.charAt(m)) {
                this.memo[n][m] = 1 + this.length(n + 1, m + 1);
            } else {
                this.memo[n][m] = Math.max(this.length(n + 1, m),
                                           this.length(n, m + 1));
            }
        }
        //Return the value in the  array
        return memo[n][m];
    }

    public String backtrack(int n, int m) {
        if (n == this.str1.length() || m == this.str2.length()) {
            return "";
        } else if (this.str1.charAt(n) == this.str2.charAt(m)) {
            return this.str1.charAt(n) + this.backtrack(n + 1, m + 1);
        } else if (this.memo[n][m + 1] > this.memo[n + 1][m]) {
            return this.backtrack(n, m + 1);
        } else {
            return this.backtrack(n + 1, m);
        }
    }

    public HashSet<String> backtrackAll(int n, int m) {
        if (n == this.str1.length() - 1 || m == this.str2.length() - 1) {

            return new HashSet<String>();
        } else {
            if (this.str1.charAt(n) == this.str2.charAt(m)) {

                HashSet<String> R = this.backtrackAll(n + 1, m + 1);
                HashSet<String> new_set = new HashSet<String>();

                for (String Z : R) {
                    new_set.add(Z + this.str1.charAt(n));
                }
                new_set.add("" + this.str1.charAt(n));
                System.out.println(new_set);
                return new_set;
            } else {
                HashSet<String> R = new HashSet<String>();
                if (this.memo[n][m + 1] >= this.memo[n + 1][m]) {
                    R = this.backtrackAll(n, m + 1);
                } else {
                    R = this.backtrackAll(n + 1, m);
                }
                return R;
            }
        }
    }

    @Override
    public String toString() {
        return "The length of a longest common subsequence of " + str1 + " and " + str2 + " is " + this.length(
                0, 0) + "\nOne common subsequence is " + this.backtrackAll(0, 0);

    }

}
