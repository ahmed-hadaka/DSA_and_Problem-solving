package Div2_B;

import java.util.Scanner;

/*
 * code: https://codeforces.com/contest/66/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */
public class Petya_and_Countryside {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 1, min = 1000, c = 1, elem1, elem2, j, k;
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < min)
                min = arr[i];
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        for (int i = 0; i < n; i++) {
            elem1 = arr[i];
            j = i + 1;
            if (j != arr.length) {
                while (arr[j] <= elem1) {
                    c++;
                    elem1 = arr[j];
                    j++;
                    if (j == arr.length) break;
                }
            }
            elem2 = arr[i];
            k = i - 1;
            if (k >= 0) {
                while (arr[k] <= elem2) {
                    c++;
                    elem2 = arr[k];
                    k--;
                    if (k < 0) break;
                }
            }
            if (c > res) {
                res = c;
            }
            if (res == n)
                break;
            c = 1;
        }

        System.out.println(res);
    }
}
