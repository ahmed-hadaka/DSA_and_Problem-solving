package Div2_A;
/*
 * code: CF59-D2-Div2_A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input, upperInput;
        int upper = 0, lower = 0;
        input = sc.next();
        upperInput = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == upperInput.charAt(i))
                upper++;
            else
                lower++;
        }
        if (upper == lower || lower > upper)
            System.out.println(input.toLowerCase());
        else
            System.out.println(upperInput);
    }
}
