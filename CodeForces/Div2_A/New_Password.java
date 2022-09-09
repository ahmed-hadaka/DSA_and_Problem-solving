package Div2_A;
/*
 * code: http://codeforces.com/contest/490/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class New_Password {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, j = 0;

        char[] chA = new char[26];
        for (int i = 97; i <= 122; i++) {
            chA[j] = (char) i;
            j++;
        }

        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < k && n > 0; i++) {
            System.out.print(chA[i]);
            n--;
            if (i == (k - 1) && n > 0)
                i = -1;
        }

    }
}
