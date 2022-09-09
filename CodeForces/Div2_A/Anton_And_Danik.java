package Div2_A;
/*
 * code: http://codeforces.com/contest/734/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Anton_And_Danik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input, anton = 0, danik = 0;
        String st;
        char[] ch;
        input = sc.nextInt();
        st = sc.next();
        ch = st.toCharArray();
        for (int i = 0; i < input; i++) {
            if (ch[i] == 'A')
                anton++;
            else
                danik++;
        }
        if (anton > danik)
            System.out.println("Anton");
        else if (danik > anton)
            System.out.println("Danik");
        else
            System.out.println("Friendship");
    }
}

