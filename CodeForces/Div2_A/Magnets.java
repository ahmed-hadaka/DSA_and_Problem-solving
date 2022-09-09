package Div2_A;

import java.util.Scanner;

/*
 * code: CF344-D2-Div2_A
 *
 * @ author: Ahmed_Hadaka
 * */
public class Magnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, groups = 0, input;
        int[] arr;

        input = sc.nextInt();
        arr = new int[input];
        for (int i = 0; i < input; i++) { // fill arr
            arr[i] = sc.nextInt();
        }
        if (input == 1)
            System.out.println(1);
        else {
            while (count < arr.length - 1) { // 1 -- 1
                while (count < arr.length - 1 && arr[count] % 10 != arr[count + 1] / 10)
                    count++;
                groups++;
                count++;
            }
            if (count == arr.length - 1)
                groups++;
            System.out.println(groups);
        }

    }
}
