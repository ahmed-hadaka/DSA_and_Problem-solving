package Div2_A;

/*
 * code: http://codeforces.com/contest/208/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, nStr = "";
        int j;
        char[] arr;
        List<String> arrL = new ArrayList<>();
        str = sc.next();
        arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 2 && arr[i] == 'W' && arr[i + 1] == 'U' && arr[i + 2] == 'B' ) {
                arr[i] = ' ';
                arr[i + 1] = ' ';
                arr[i + 2] = ' ';
                i += 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' '){
                j = i;
                while (j < arr.length && arr[j] != ' '){
                    nStr += arr[j];
                    j++;
                }
                i = j - 1;
                arrL.add(nStr);
                nStr = "";
            }
        }
        for (String s: arrL) {
            System.out.print(s+" ");
        }
    }
}
