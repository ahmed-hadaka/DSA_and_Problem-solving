package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Insert_a_node_at_a_specific_position {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            LinkedList.insertLast(sc.nextInt());
        }
        int data = sc.nextInt();
        int position = sc.nextInt();
        LinkedList.insertAt(data, position);
        LinkedList.display();
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

        public static void insertAt(int data, int position) {
            Node newN = new Node(data);
            Node current = head;
            if (position == 0) {
                newN.next = head;
                head = newN;
            } else {
                int i = 0;
                while (i < position - 1) {
                    current = current.next;
                    i++;
                }
                newN.next = current.next;
                current.next = newN;
            }
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
