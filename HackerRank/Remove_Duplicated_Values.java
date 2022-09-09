    package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Remove_Duplicated_Values {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                data = sc.nextInt();
                if (!LinkedList.contains(data)) {
                    LinkedList.insertLast(data);
                }
            }
            LinkedList.display();
            System.out.println();
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

        public static void insertLast(int data) {
            Node newN = new Node(data);
            if (isEmpty())
                head = newN;
            else
                last.next = newN;
            last = newN;
        }

        public static boolean contains(int data) {
            Node current = head;
            while (current != null) {
                if (current.DATA == data)
                    return true;
                current = current.next;
            }
            return false;
        }

        public static Node removeFirst() {
            Node removed = head;
            head = head.next;
            return removed;
        }

        public static void display() {
            while (!isEmpty()) {
                System.out.print(removeFirst().DATA + " ");
            }
        }

        public static boolean isEmpty() {
            return head == null;
        }
    }
}
