package HackerRank.DataStructures.Arrays;

/*
 * code:https://www.hackerrank.com/challenges/arrays-ds
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;
import java.util.Stack;

public class Arrays_DS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
