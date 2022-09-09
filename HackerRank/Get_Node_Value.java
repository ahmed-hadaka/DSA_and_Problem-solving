package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Get_Node_Value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                LinkedList.insertLast(sc.nextInt());
            }
            int pos = sc.nextInt();
            int val = LinkedList.getValueAt(pos);
            System.out.println(val);
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

        public static int getValueAt(int position) {
            Node current = head;
            int i = size - 1;
            while (i > position) {
                current = current.next;
                i--;
            }
            return current.DATA;
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

