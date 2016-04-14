/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

/**
 *
 * @author lftomazini
 */
public class TestLCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LCS lcs = new LCS("ABCBDAB", "BDCABA");

        System.out.println(lcs.toString());
    }

}
