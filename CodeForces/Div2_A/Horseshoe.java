package Div2_A;
/*
 * code: http://codeforces.com/contest/228/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Horseshoe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, x;
        int[]arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) continue;
            x = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] == 0) continue;
                if(arr[j]== x)
                    arr[j] = 0;
            }
        }
        for (int item: arr) {
            if (item != 0)
                count++;
        }
        System.out.println(4- count);
    }
}
