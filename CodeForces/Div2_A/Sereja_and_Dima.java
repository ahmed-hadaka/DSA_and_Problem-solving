package Div2_A;
/*
 * code: CF381-D2-Div2_A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Sereja_and_Dima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int i = 0, input, head = 0, tail, max = 0, sereja = 0, dima = 0, turn = 0;
        input = sc.nextInt();
        arr = new int[input];
        tail = arr.length - 1;

        while (i < input) { // fill arr
            arr[i] = sc.nextInt();
            i++;
        }

        while (head <= tail) {
            max = Math.max(arr[head], arr[tail]);
            if (max == arr[tail])
                tail--;
            else
                head++;
            if (turn % 2 == 0) // sereje turn
                sereja += max;
            else
                dima += max;
            turn++;
        }
        System.out.println(sereja +"\n"+dima);

    }
}
