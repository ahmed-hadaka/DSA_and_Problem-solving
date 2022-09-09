package HackerRank.DataStructures.Arrays;

/*
 * code: https://www.hackerrank.com/challenges/dynamic-array/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dynamic_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> queries = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int lastAnswer = 0;
        int n = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < q; i++) {  // take input
            List<Integer> query = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                query.add(sc.nextInt());
            }
            queries.add(query);
        }
        for (List<Integer> query : queries) {
            int x = query.get(1);
            int y = query.get(2);
            int index = (x ^ lastAnswer) % n;
            if (query.get(0) == 1) {
                arr.get(index).add(y);
            } else {
                lastAnswer = arr.get(index).get(y % arr.get(index).size());
                ans.add(lastAnswer);
            }
        }
        for (int item : ans) {
            System.out.println(item);
        }
    }
}
