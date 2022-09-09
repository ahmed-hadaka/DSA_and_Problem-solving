package Div2_B;

/*
 * check : CF78-D2-B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Easter_Eggs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};
        int j = 0;
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(arr[j++]);
            if (j == 7)
                j = 3;
        }
        System.out.println(str);
    }
}
