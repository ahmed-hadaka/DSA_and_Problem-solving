package Div2_A;
/*
 * code: CF236-D2-Div2_A
 *
 * @ author: Ahmed_Hadaka
 * */
import java.util.LinkedList;
import java.util.Scanner;

public class Boy_or_Girl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int length;
        input = sc.next();

        length = getLength(input);
        if (length % 2 == 0)  // even
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
    static LinkedList<Character> chL = new LinkedList<>();
    public static int getLength(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (i == 0){
                chL.add(input.charAt(i));
                continue;
            }
            if (!isHere(input.charAt(i)))
                chL.add(input.charAt(i));
        }
        return chL.size();
    }
    public static boolean isHere(char chI) {
        for (char ch: chL) {
            if (chI == ch)
                return true;
        }
        return false;
    }
}
