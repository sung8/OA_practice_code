package recursion_basic.pointers.linked_list;

public class SumOfElements {

    // Definition for singly-linked list node.
    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Method to convert an array into a singly linked list.
    public ListNode arrayToList(int[] arr) {
        ListNode dummyHead = new ListNode(0); // Dummy head node
        ListNode curr = dummyHead;

        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummyHead.next; // Return the actual head of the list
    }

    // Method to print the elements of a linked list.
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println(); // Move to the next line after printing
    }

    // Method to calculate the sum of elements in the linked list using recursion.
    public int sumOfElements(ListNode head) {
        // Base case: if the list is empty, return 0.
        if (head == null) {
            return 0;
        }

        // Recursive case: sum the current node's value with the sum of the remaining
        // list.
        return head.value + sumOfElements(head.next);
    }

    // Example usage
    public static void main(String[] args) {
        SumOfElements solution = new SumOfElements();

        // Convert an array to a linked list
        int[] arr = { 1, 2, 3, 4 };
        ListNode head = solution.arrayToList(arr);

        // Print the linked list
        solution.printList(head); // Output: 1 -> 2 -> 3 -> 4

        // Calculating the sum of elements
        int sum = solution.sumOfElements(head);

        // Printing the result
        System.out.println("Sum of elements: " + sum); // Output: Sum of elements: 10
    }
}
