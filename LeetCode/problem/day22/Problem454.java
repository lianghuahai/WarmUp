package problem.day22;

import java.util.Arrays;

public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int nAB = A.length * B.length;
    int[] sumAB = new int[nAB];
    int i = 0;
    for (int a : A) {
        for (int b : B) {
            sumAB[i++] = a + b;
        }
    }
    Arrays.sort(sumAB);
    int nCD = C.length * D.length;
    int[] negSumCD = new int[nCD];
    i = 0;
    for (int c : C) {
        for (int d : D) {
            negSumCD[i++] = - (c + d);
        }
    }
    Arrays.sort(negSumCD);
    // if sumAB = negSumCD, then 4 sum = 0
    i = 0;
    int j = 0;
    int res = 0;
    while (i < nAB && j < nCD) {
        if (sumAB[i] < negSumCD[j]) i++;
        else if (sumAB[i] > negSumCD[j]) j++;
        else {
            // sumAB[i] == negSumCD[j]
            // need to count number of same consecutive values, and multiply them
            int countAB = 1, countCD = 1;
            while (++i < nAB && sumAB[i-1] == sumAB[i]) countAB += 1;
            while (++j < nCD && negSumCD[j-1] == negSumCD[j]) countCD += 1;
            res += countAB * countCD;
        }
    }
    return res;
}}
