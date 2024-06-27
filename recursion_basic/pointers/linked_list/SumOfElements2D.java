package recursion_basic.pointers.linked_list;

public class SumOfElements2D {
    // Definition for 2D linked list node.
    class ListNode2D {
        int value;
        ListNode2D right;
        ListNode2D down;

        ListNode2D(int value) {
            this.value = value;
            this.right = null;
            this.down = null;
        }
    }

    // Method to convert a 2D array into a 2D linked list (matrix).
    public ListNode2D arrayTo2DList(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create the first node of the matrix (top-left corner)
        ListNode2D[][] nodes = new ListNode2D[rows][cols];
        nodes[0][0] = new ListNode2D(matrix[0][0]);

        // Fill the first row
        for (int j = 1; j < cols; j++) {
            nodes[0][j] = new ListNode2D(matrix[0][j]);
            nodes[0][j - 1].right = nodes[0][j];
        }

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            nodes[i][0] = new ListNode2D(matrix[i][0]);
            nodes[i - 1][0].down = nodes[i][0];
        }

        // Fill the rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                nodes[i][j] = new ListNode2D(matrix[i][j]);
                nodes[i - 1][j].down = nodes[i][j];
                nodes[i][j - 1].right = nodes[i][j];
            }
        }

        return nodes[0][0]; // Return the head of the matrix
    }

    // Method to print the elements of the 2D linked list (matrix).
    public void print2DList(ListNode2D head) {
        ListNode2D row = head;
        while (row != null) {
            ListNode2D current = row;
            while (current != null) {
                System.out.print(current.value);
                if (current.right != null) {
                    System.out.print(" -> ");
                }
                current = current.right;
            }
            System.out.println(); // Move to the next row
            row = row.down;
        }
    }

    // Method to calculate the sum of elements in the 2D linked list (matrix) using
    // recursion.
    public int sumOfElements(ListNode2D head) {
        // Base case: if the matrix is empty, return 0.
        if (head == null) {
            return 0;
        }

        // Sum of current row + sum of remaining matrix below
        return sumOfRow(head) + sumOfElements(head.down);
    }

    // Iterative method to calculate the sum of elements in the 2D linked list
    // (matrix).
    public int sumOfElementsIter(ListNode2D head) {
        int sum = 0;
        ListNode2D currentRow = head;

        // Iterate through each row
        while (currentRow != null) {
            ListNode2D current = currentRow;

            // Iterate through each element in the row
            while (current != null) {
                sum += current.value;
                current = current.right;
            }

            // Move to the next row
            currentRow = currentRow.down;
        }

        return sum;
    }

    // Helper method to calculate the sum of elements in a single row.
    private int sumOfRow(ListNode2D row) {
        if (row == null) {
            return 0;
        }

        return row.value + sumOfRow(row.right);
    }

    // Example usage
    public static void main(String[] args) {
        SumOfElements2D solution = new SumOfElements2D();

        // Example 2D array (3x3 matrix)
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Convert the 2D array to a 2D linked list
        ListNode2D head = solution.arrayTo2DList(matrix);

        // Print the 2D linked list (matrix)
        solution.print2DList(head);

        // Calculate the sum of elements in the 2D linked list
        int sum = solution.sumOfElements(head);

        int sum2 = solution.sumOfElementsIter(head);

        // Print the sum of elements
        System.out.println("Recursive Sum of elements: " + sum); // Output: Sum of elements: 45
        // Print the sum of elements
        System.out.println("Iterative Sum of elements: " + sum2); // Output: Sum of elements: 45
    }
}
