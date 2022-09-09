package HackerRank.DataStructures.LinkedList;

/*
 * code: https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Compare_Two_Linked_Lists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            DoubleLinkedList1 l1 = new DoubleLinkedList1();
            DoubleLinkedList1 l2 = new DoubleLinkedList1();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                l1.insertLast(sc.nextInt());
            }
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                l2.insertLast(sc.nextInt());
            }
            System.out.println(l2.compare(l1));
        }
    }
}

class Node1 {
    private final int DATA;
    Node1 next;

    public Node1(int data) {
        this.DATA = data;
    }

    public int getDATA() {
        return DATA;
    }
}

class DoubleLinkedList1 {
    private int size = 0;
    private Node1 head;
    private Node1 last;

    public void insertLast(int data) {
        Node1 newN = new Node1(data);
        if (isEmpty())
            head = newN;
        else
            last.next = newN;
        last = newN;
        size++;
    }

    public Node1 pop() {
        Node1 removed = head;
        head = head.next;
        size--;
        return removed;
    }

    public int compare(DoubleLinkedList1 l2) {
        if (this.getSize() == l2.getSize()) {
            while (!this.isEmpty()) {
                if (this.pop().getDATA() != l2.pop().getDATA())
                    return 0;
            }
            return 1;
        } else return 0;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.print(pop().getDATA() + " ");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return this.size;
    }
}

