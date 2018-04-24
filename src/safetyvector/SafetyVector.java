/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyvector;

/**
 *
 * @author rajor
 */
public class SafetyVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 

        int[][] SV = new int[16][4];
        int[] FN = {3,4,5,14,15};
        int[][] N = {
            {1, 2, 4, 8}, //0
            {0, 3, 5, 9},//1
            {0, 3, 6, 10},//2
            {1, 2, 7, 11},//3
            {0, 5, 6, 12},//4
            {1, 4, 7, 13},//5
            {2, 4, 7, 14},//6
            {3, 5, 6, 15},//7
            {0, 9, 10, 12},//8
            {1, 8, 11, 13},//9
            {2, 8, 11, 14},//10
            {3, 9, 10, 15},//11
            {4, 8, 13, 14},//12
            {5, 9, 12, 15},//13
            {6, 10, 12, 15},//14
            {7, 11, 13, 14}//15
        };

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                SV[i][j] = 1;
            }

        }
        int[][] SV2 = new int[16][4];
        for (int i : FN) {
            for (int j = 0; j < 4; j++) {
                SV[i][j] = 0;
            }
        }

        for (int i = 0; i < 16; i++) {
            System.out.print(i + ": [");
            for (int j = 0; j < 4; j++) {
                System.out.print(SV[i][j]);
            }
            System.out.print("]\t");
        }
        System.out.println("\nAlgorithm Starts");
        int round = 3;
        while (round-- > 0) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 4; j++) {
                    boolean flag = false;
                    for (int fn : FN) {
                        if (fn == i) {
                            flag = true;
                        }
                    }
                    if (flag == true) {
                        continue;
                    }
                    if (j == 0) {
                        SV2[i][j] = SV[i][j];
                    } else {
                        int k = j + 1;
                        int sum = 0;
                        for (int n : N[i]) {
                            sum += SV[n][j - 1];
                        }
                        if (sum <= 4 - k) {
                            SV2[i][j] = 0;
                        } else {
                            SV2[i][j] = 1;
                        }
                    }

                }
            }
            SV = SV2;
            for (int i = 0; i < 16; i++) {
                System.out.print(i + ": [");
                for (int j = 0; j < 4; j++) {
                    System.out.print(SV[i][j]);
                }
                System.out.print("]\t");

            }

            System.out.println("");

        }
    }

}
