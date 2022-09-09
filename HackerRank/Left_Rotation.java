package HackerRank.DataStructures.Arrays;

/*
 * code:https://www.hackerrank.com/challenges/array-left-rotation
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Left_Rotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp;
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // fill
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < d; i++) {
            temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = temp;
        }
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
