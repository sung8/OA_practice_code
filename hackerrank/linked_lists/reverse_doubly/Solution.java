package hackerrank.linked_lists.reverse_doubly;

import java.io.*;
// import java.util.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static class Result {

        /*
         * Complete the 'reverse' function below.
         *
         * The function is expected to return a DOUBLY_LINKED_LIST.
         * The function accepts DOUBLY_LINKED_LIST llist as parameter.
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         * int data;
         * DoublyLinkedListNode next;
         * DoublyLinkedListNode prev;
         * }
         *
         */

        public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
            if (llist == null) {
                return null;
            }
            DoublyLinkedListNode curr = llist;
            DoublyLinkedListNode temp = null;
            while (curr != null) {
                temp = curr.prev;
                curr.prev = curr.next;
                curr.next = temp;
                curr = curr.prev;
            }
            if (temp != null) {
                llist = temp.prev;
            }
            return llist;
        }
    }

    public static void main(String[] args) throws IOException {
        String inputFilePath = "input07.txt"; // Change to your input file path
        String outputFilePath = "output.txt"; // Change to your output file path

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

            for (int i = 0; i < llistCount; i++) {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = Result.reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
