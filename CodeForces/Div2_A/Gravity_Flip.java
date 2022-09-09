package Div2_A;
/*
 * code:http://codeforces.com/contest/405/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Gravity_Flip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nColumns;
        nColumns = sc.nextInt();

        int[] arr = new int[nColumns];

        for (int i = 0; i < nColumns; i++) { // fill arr
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(i, min, arr);
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
