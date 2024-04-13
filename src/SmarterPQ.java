/**
 * Navjot Kamboj- 40240781 and Yatish Chutani -40266553
 * COMP 6481 (Programming and Problem-Solving)
 * Programming Assignment #3
 * Due Date: 14th April 2024
 */

public class SmarterPQ {
    private Node root;
    private int size;
    private boolean isMinHeap;

    // Internal class to represent a node in the linked list
    public class Node {
        int key;
        Object value;
        Node left;
        Node right;

        Node(int key, Object value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public SmarterPQ() {
        this.root = null;
        this.size = 0;
        this.isMinHeap = true; // Initially set as min heap
    }

    // Method to toggle between min and max heaps
    public void toggle() {
        isMinHeap = !isMinHeap;
        // Re-heapify the heap to maintain the new state
        heapify(root);
    }

    // Method to insert a key-value pair into the priority queue
    public Node insert(int k, Object v) {
        Node newNode = new Node(k, v);
        size++;
        if (root == null) {
            root = newNode;
        } else {
            // Find the correct position to insert the new node
            insertHelper(root, newNode);
        }
        // Percolate the newly inserted element up to its correct position
        heapifyUp(newNode);
        return newNode;
    }

    // Helper method to find the correct position to insert a new node
    private void insertHelper(Node current, Node newNode) {
        if (current.left == null) {
            current.left = newNode;
        } else if (current.right == null) {
            current.right = newNode;
        } else {
            // Traverse to the next level
            insertHelper(current.left, newNode);
        }
    }

    // Method to remove and return the top element of the priority queue
    public Node removeTop() {
        if (isEmpty()) {
            return null;
        }
        Node top = root;
        // Find the rightmost node in the last level
        Node rightmost = findRightmost(root);
        // Swap the top node with the rightmost node
        swapNodes(root, rightmost);
        // Remove the rightmost node
        if (rightmost == root) {
            root = null;
        } else {
            Node parent = findParent(root, rightmost);
            if (parent.right == rightmost) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        }
        size--;
        // Percolate down the new root node to its correct position
        heapifyDown(root);
        return top;
    }

    // Method to find the rightmost node in the last level
    private Node findRightmost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Method to find the parent of a node
    private Node findParent(Node current, Node target) {
        if (current == null || current.left == target || current.right == target) {
            return current;
        }
        Node left = findParent(current.left, target);
        if (left != null) {
            return left;
        }
        return findParent(current.right, target);
    }

    // Method to remove a specific entry from the priority queue
    public Node remove(Node target) {
        if (target == root) {
            return removeTop();
        }
        Node parent = findParent(root, target);
        if (parent == null) {
            return null; // Target node not found
        }
        // Swap the target node with the rightmost node in the last level
        swapNodes(target, findRightmost(root));
        // Remove the rightmost node
        if (parent.right == target) {
            parent.right = null;
        } else {
            parent.left = null;
        }
        size--;
        // Percolate down the new node to its correct position
        heapifyDown(target);
        return target;
    }

    // Method to replace the key of a specific entry
    public int replaceKey(Node node, int k) {
        int oldKey = node.key;
        node.key = k;
        // Percolate the node up or down to maintain heap property
        heapify(node);
        return oldKey;
    }

    // Method to replace the value of a specific entry
    public Object replaceValue(Node node, Object v) {
        Object oldValue = node.value;
        node.value = v;
        return oldValue;
    }

    // Method to return the top entry without removing it
    public Node top() {
        return root;
    }

    // Method to return the current state of the priority queue
    public String state() {
        return isMinHeap ? "Min" : "Max";
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to return the size of the priority queue
    public int size() {
        return size;
    }

    // Method to percolate a node up to its correct position in the heap
    private void heapifyUp(Node node) {
        Node current = node;
        while (current != root) {
            Node parent = findParent(root, current);
            if ((isMinHeap && current.key < parent.key) || (!isMinHeap && current.key > parent.key)) {
                swapNodes(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    // Method to percolate a node down to its correct position in the heap
    private void heapifyDown(Node node) {
        while (node.left != null || node.right != null) {
            Node smallestChild = node.left;
            if (node.right != null && ((isMinHeap && node.right.key < node.left.key)
                    || (!isMinHeap && node.right.key > node.left.key))) {
                smallestChild = node.right;
            }
            if ((isMinHeap && smallestChild.key < node.key) || (!isMinHeap && smallestChild.key > node.key)) {
                swapNodes(node, smallestChild);
                node = smallestChild;
            } else {
                break;
            }
        }
    }

    // Method to swap two nodes in the heap
    private void swapNodes(Node node1, Node node2) {
        int tempKey = node1.key;
        Object tempValue = node1.value;
        node1.key = node2.key;
        node1.value = node2.value;
        node2.key = tempKey;
        node2.value = tempValue;
    }
    private void heapify(Node node) {
        if (node == null) {
            return;
        }
        if (isMinHeap) {
            heapifyMin(node);
        } else {
            heapifyMax(node);
        }
    }
    private void heapifyMin(Node node) {
        Node smallest = node;
        Node left = node.left;
        Node right = node.right;

        if (left != null && left.key < smallest.key) {
            smallest = left;
        }
        if (right != null && right.key < smallest.key) {
            smallest = right;
        }

        if (smallest != node) {
            swapNodes(node, smallest);
            heapifyMin(smallest);
        }
    }

    // Method to heapify the tree rooted at 'node' as a max heap
    private void heapifyMax(Node node) {
        Node largest = node;
        Node left = node.left;
        Node right = node.right;

        if (left != null && left.key > largest.key) {
            largest = left;
        }
        if (right != null && right.key > largest.key) {
            largest = right;
        }

        if (largest != node) {
            swapNodes(node, largest);
            heapifyMax(largest);
        }
    }
}
