package Div2_A;

/*
 * code: http://codeforces.com/contest/520/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, j = 0;
        String str;
        char[] chA;
        n = sc.nextInt();
        str = sc.next();
        chA = str.toLowerCase().toCharArray();
        if (chA.length < 26)
            System.out.println("NO");
        else {
            Arrays.sort(chA);
            for (int i = 0; i < n - 1; i++) {
                if (chA[i] != chA[i + 1])
                    chA[j++] = chA[i];
            }
            chA[j++] = chA[n - 1]; // put last item
            if (j == 26)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
