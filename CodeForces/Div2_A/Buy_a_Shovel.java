package Div2_A;
/*
 * code: http://codeforces.com/contest/732/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Buy_a_Shovel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shovel = 1, k, r, coins;
        k = sc.nextInt();
        r = sc.nextInt();
        coins = k;
        while (coins % 10 != 0) {
            if (coins % 10 == r)
                break;
            shovel++;
            coins = k * shovel;

        }
        System.out.println(shovel);
    }
}
