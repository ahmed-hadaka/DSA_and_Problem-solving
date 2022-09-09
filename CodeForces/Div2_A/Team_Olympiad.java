package Div2_A;

/*
 * code: http://codeforces.com/contest/490/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class Team_Olympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, skills, min1, min2;
        ArrayList<Integer> once = new ArrayList<>();
        ArrayList<Integer> twice = new ArrayList<>();
        ArrayList<Integer> thirds = new ArrayList<>();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            skills = sc.nextInt();
            if (skills == 1)
                once.add(i + 1);
            else if (skills == 2)
                twice.add(i + 1);
            else
                thirds.add(i + 1);
        }
        if (once.size() == 0 || twice.size() == 0 ||thirds.size() == 0)
            System.out.println(0);
        else {
             min1 = Math.min(once.size(), twice.size());
             min2 = Math.min(min1, thirds.size());
            System.out.println(min2);
            for (int i = 0; i < min2; i++) {
                System.out.println(once.get(i) + " " + twice.get(i) + " " + thirds.get(i));
            }
        }

    }
}
