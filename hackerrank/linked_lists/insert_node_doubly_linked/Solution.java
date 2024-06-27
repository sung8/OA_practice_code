package hackerrank.linked_lists.insert_node_doubly_linked;

import java.io.*;

// Sample Input
// STDIN   Function
// -----   --------
// 1       t = 1
// 4       n = 4
// 1       node data values = 1, 3, 4, 10
// 3
// 4
// 10
// 5       data = 5

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

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if (llist == null) {
            return node;
        } else if (data <= llist.data) {
            node.next = llist;
            llist.prev = node;
            return node;
        } else {
            DoublyLinkedListNode ptr = sortedInsert(llist.next, data);
            llist.next = ptr;
            ptr.prev = llist;
            return llist;
        }
    }

    public static void main(String[] args) throws IOException {
        String inputFilePath = "input00.txt"; // Change to your input file path
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

            int data = Integer.parseInt(bufferedReader.readLine().trim());

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
