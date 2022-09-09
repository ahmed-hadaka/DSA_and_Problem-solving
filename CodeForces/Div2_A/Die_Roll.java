package Div2_A;

/*
 * code: http://codeforces.com/contest/9/problem/A
 *hint
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Die_Roll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y, w;
        y = sc.nextInt();
        w = sc.nextInt();
        String[] pro = {"1/1", "5/6", "2/3", "1/2", "1/3", "1/6"};

        int max = Math.max(y, w);
        System.out.println(pro[max-1]);

    }
}
