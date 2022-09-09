package Div2_A;
/*
 * code: http://codeforces.com/contest/339/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Helpful_Maths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int[] arr;
        int j = 0, temp;
        str = sc.next();
        if (str.length() == 1)
            System.out.println(Integer.parseInt(str));
        else {
            arr = new int[(str.length() / 2) + 1];

            for (int i = 0; i < str.length(); i += 2) {
                arr[j] = Integer.parseInt(String.valueOf(str.charAt(i)));
                j++;
            }

            int end = arr.length - 1;
            for (int i = 0; i < arr.length - 1; i++) {   // bubble sort
                for (int k = 0; k < end; k++) {
                    if (arr[k] > arr[k + 1]) {
                        temp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = temp;
                    }
                }
                end--;
            }

            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + "+");
            }
            System.out.println(arr[arr.length - 1]);
        }

    }
}
