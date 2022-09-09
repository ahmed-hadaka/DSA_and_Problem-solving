package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list?isFullScreen=true
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Delete_Node {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            DoubleLinkedList.insertLast(sc.nextInt());
        }
        DoubleLinkedList.deleteAt(sc.nextInt());
        DoubleLinkedList.display();
    }

    public static class Node {
        final int DATA;
        Node next;

        public Node(int data) {
            this.DATA = data;
        }
    }

    public static class DoubleLinkedList {
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

        public static void deleteAt(int position) {
            Node current = head, parent = head;
            int i = 0;
            while (i < position) {
                parent = current;
                current = current.next;
                i++;
            }
            parent.next = current.next;
            if (current == parent) {
                head = head.next;
            } else if (current == last)
                last = parent;
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
