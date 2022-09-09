package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Reverse_LinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                LinkedList.insertLast(sc.nextInt());
            }
            LinkedList.doReverse();
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

        public static void doReverse() {
            Node temp, parent = head, current = head;
            while (current != null) {
                temp = parent;
                parent = current;
                current = current.next;
                if (temp == head)
                    temp.next = null;
                parent.next = temp;
            }
            head = parent;
        }

        public static Node removeHead() {
            Node removed = head;
            head = head.next;
            return removed;
        }

        public static void display() {
            while (!isEmpty()) {
                System.out.print(removeHead().DATA + " ");
            }
        }

        public static boolean isEmpty() {
            return head == null;
        }
    }
}
