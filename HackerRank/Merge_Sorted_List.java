package HackerRank.DataStructures.LinkedList;
/*
 * code: https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Merge_Sorted_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList l1 = new DoubleLinkedList();
        DoubleLinkedList l2 = new DoubleLinkedList();
        DoubleLinkedList l3 = new DoubleLinkedList();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                l1.insertLast(sc.nextInt());
            }
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                l2.insertLast(sc.nextInt());
            }
            l3.sortedInsertion(l1, l2);
            l3.display();
            System.out.println();
        }
    }
}

class Node {
    final int DATA;
    Node next;

    public Node(int data) {
        this.DATA = data;
    }
}

class DoubleLinkedList {
    Node head;
    Node last;

    public void insertLast(int data) {
        Node newN = new Node(data);
        if (isEmpty())
            head = newN;
        else
            last.next = newN;
        last = newN;
    }

    public Node peek() {
        return this.head;
    }

    public void sortedInsertion(DoubleLinkedList l1, DoubleLinkedList l2) {
        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (l1.peek().DATA > l2.peek().DATA)
                this.insertLast(l2.removeFirst().DATA);
            else
                this.insertLast(l1.removeFirst().DATA);
        }
        while (!l1.isEmpty())
            this.insertLast(l1.removeFirst().DATA);
        while (!l2.isEmpty())
            this.insertLast(l2.removeFirst().DATA);
    }

    public Node removeFirst() {
        Node removed = head;
        head = head.next;
        return removed;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.print(removeFirst().DATA + " ");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
