package HackerRank.DataStructures.Arrays;

/*
 * code:https://www.hackerrank.com/challenges/sparse-arrays/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.*;
public class Sparse_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listStrings = new ArrayList<>();
        ArrayList<String> listQueries = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) { // fill
            listStrings.add(sc.next());
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {  // fill
            listQueries.add(sc.next());
        }
        for (String str : listQueries) {
            System.out.println(Collections.frequency(listStrings, str));
        }
    }
}
