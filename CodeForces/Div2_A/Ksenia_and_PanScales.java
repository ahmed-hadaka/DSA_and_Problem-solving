package Div2_A;

/*
 * code: http://codeforces.com/contest/514/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ksenia_and_PanScales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String s1 = sc.next();
        String s2 = sc.next();
        char[] arr1 = s1.toCharArray();
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (arr1[i] == '|') {
                flag = true;
                continue;
            }
            if (!flag) {
                list1.add(s1.charAt(i));
            } else {
                list2.add(s1.charAt(i));
            }
        }
        if ((list1.size() + list2.size() + s2.length()) % 2 != 0)
            System.out.println("Impossible");
        else {
            for (int i = 0; i < s2.length(); i++) {
                if (list1.size() < list2.size())
                    list1.add(s2.charAt(i));
                else
                    list2.add(s2.charAt(i));
            }
            if (list1.size() != list2.size())
                System.out.println("Impossible");
            else {
                for (Character ch : list1) {
                    System.out.print(ch);
                }
                System.out.print('|');
                for (Character ch : list2)
                    System.out.print(ch);
            }
        }
    }
}
