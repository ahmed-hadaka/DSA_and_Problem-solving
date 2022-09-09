package HackerRank.DataStructures.LinkedList;

import java.util.Scanner;

/*
 * code: https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 *
 * @ author: Ahmed_Hadaka
 * */
public class Insert_at_the_End {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            LinkedList.insertLast(sc.nextInt());
        }
        while (!LinkedList.isEmpty()) {
            System.out.println(LinkedList.removeHead().DATA);
        }
    }

    public static class Node {
        final int DATA;
        Node next;

        public Node(int data) {
            this.DATA = data;
        }
    }

    public static class LinkedList {
        static Node head;
        static Node last;
        static int size;

        public static void insertLast(int data) {
            Node newN = new Node(data);
            if (isEmpty())
                head = newN;
            else
                last.next = newN;
            last = newN;
            size++;
        }


        public static Node removeHead() {
            Node removed = head;
            head = head.next;
            size--;
            return removed;
        }

        public static void display() {
            while (!isEmpty()) {
                System.out.println(removeHead().DATA + " ");
            }
        }

        public static boolean isEmpty() {
            return head == null;
        }
    }
}
