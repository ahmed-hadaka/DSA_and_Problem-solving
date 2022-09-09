package Div2_B;

/*
 * check : http://codeforces.com/contest/451/problem/B
 *
 * @ author: Ahmed_Hadaka
 m*/


import java.util.Arrays;
import java.util.Scanner;

public class Sort_the_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        boolean flag1 = false;
        boolean sorted = true;
        String ans = "yes";
        int n = sc.nextInt();
        int in, index1 = 1, index2 = 1;
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) { // fill
            in = sc.nextInt();
            arr[i] = in;
            arr2[i] = in;
        }
        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr2[i]) {
                sorted = false;
                break;
            }
        }
        if (!sorted) {
            int i;
            for (i = 0; i < n - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    if (!flag)
                        index1 = i + 1;
                    flag = true;

                }
                if (arr[i + 1] > arr[i] && flag) {
                    index2 = i + 1;
                    for (int j = i + 1; j < n - 1; j++) {
                         flag1 = true;
                        if (arr[j + 1] < arr[j] || arr[index1 - 1] > arr[index2]) {
                            ans = "no";
                            break;
                        }
                    }
                    if (!flag1)  {
                        if (arr[i+1] < arr[index1-1])
                            ans = "no";
                    }
                    break;
                }
            }
            if (index2 == 1)
                index2 = i + 1;
        }
        System.out.println(ans);
        if (ans.equals("yes")) {
            System.out.println(index1 + " " + index2);
        }
    }
}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Sort_the_Array {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int index = -1;
//        String ans = "yes";
//        int n = sc.nextInt();
//        int in, nElem = 0;
//        int[] arr1 = new int[n];
//        int[] arr2 = new int[n];
//        int[] arrIndex = new int[n];
//        for (int i = 0; i < n; i++) { // fill
//            in = sc.nextInt();
//            arr1[i] = in;
//            arr2[i] = in;
//        }
//        Arrays.sort(arr2);
//        for (int i = 0; i < n; i++) {
//            if (arr1[i] != arr2[i]) {
//                arrIndex[nElem++] = i;
//                if (index != -1 && i != index + 1) {
//                    ans = "no";
//                    break;
//                }
//                index = i;
//            }
//             if  (n % 2 != 0) {//odd
//                if (i == n / 2 && arr1[i] == arr2[i]) {
//                    arrIndex[nElem++] = i;
//                    index++;
//                }
//            }
//        }
//        if (ans.equals("yes")) {
//            for (int i = nElem - 1; i > arrIndex[0]; i--) {
//                if (arr1[i] > arr1[i - 1]) {
//                    ans = "no";
//                    break;
//                }
//            }
//        }
//        System.out.println(ans);
//        if (ans.equals("yes") && nElem < 2) {
//            System.out.println("1" + " " + "1");
//        } else if (ans.equals("yes")) {
//            System.out.println((arrIndex[0] + 1) + " " + (arrIndex[nElem - 1] + 1));
//        }
//
//    }
//}
