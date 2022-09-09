package Div2_A;
/*
 * code: http://codeforces.com/contest/469/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class I_Wanna_Be_the_Guy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[200];
        int n, p, q, nElem = 0, i = 0, j = 0;
        n = sc.nextInt();
        p = sc.nextInt();
        while (i < p) {  // fill array
            arr[nElem++] = sc.nextInt();
            i++;
        }
        i = 0;
        q = sc.nextInt();
        while (i < q) {  // fill array
            arr[nElem++] = sc.nextInt();
            i++;
        }
        if ((q == 0 && p == 0) || ((p == 0 && q < n) || (q == 0 && p < n)))  // base case
            System.out.println("Oh, my keyboard!");
        else if (p == n || q == n)              // base cases
            System.out.println("I become the guy.");
        else {                               // remove duplicated and calc length
            Arrays.sort(arr);
            for (int k = 200 - nElem; k < arr.length - 1; k++)
                if (arr[k] != arr[k + 1])
                    arr[j++] = arr[k];
            arr[j++] = arr[arr.length - 1];
            if (j == n)
                System.out.println("I become the guy.");
            else
                System.out.println("Oh, my keyboard!");
        }
    }
}
