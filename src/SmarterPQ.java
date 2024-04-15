/**
 * Navjot Kamboj- 40240781 and Yatish Chutani -40266553
 * COMP 6481 (Programming and Problem-Solving)
 * Programming Assignment #3
 * Due Date: 14th April 2024
 */

class Tree {

    // Inner Node class to define Tree Structure
    static class Node {
        int key;
        Object data;
        Node left;
        Node right;
        Node parent;

        Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    Node root;
    int size;
    boolean isMaxHeap;

    Tree(boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * Method to min-heapify or max-heapify based on the type
     *
     * @param node of the tree
     */
    void heapify(Node node) {
        if (node == null) return;

        Node extremeVal = node;
        Node left = node.left;
        Node right = node.right;


        if (left != null && (isMaxHeap && left.key > extremeVal.key || !isMaxHeap && left.key < extremeVal.key)) {
            extremeVal = left;
        }

        if (right != null && (isMaxHeap && right.key > extremeVal.key || !isMaxHeap && right.key < extremeVal.key)) {
            extremeVal = right;
        }

        if (extremeVal != node) {
            int temp = node.key;
            Object tempData = node.data;
            node.key = extremeVal.key;
            node.data = extremeVal.data;
            extremeVal.key = temp;
            extremeVal.data = tempData;
            heapify(extremeVal);
        }
    }

    /**
     * Method to insert key, value pairs in the tree
     * and running heapify to re-adjust the heap  (whether max-heap / min-heap)
     *
     * @param key
     * @param data
     */
    void insert(int key, Object data) {
        if (root == null) {
            root = new Node(key, data);
            return;
        }
        Node node = root;
        while (true) {
            if (node.left == null) {
                node.left = new Node(key, data);
                break;
            } else if (node.right == null) {
                node.right = new Node(key, data);
                node.right.parent = node;
                break;
            } else {
                if (node.left.left == null || node.left.right == null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        while (node != null) {
            heapify(node);
            node = node.parent;
        }
    }

    /**
     * Method to find the last Node in the tree which can be replaced with the deleted node.
     *
     * @return last Node
     */
    public Node findLastNode() {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node.left != null || node.right != null) {
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * Method to display the Tree Elements as inserted in the Priority Queue
     *
     * @param node
     */
    void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Root Node: Key => " + node.key + ", Value => " + node.data +
                " Left Node: " + (node.left != null ? "Key => " + node.left.key + ", Value => " + node.left.data : "null") +
                " Right Node: " + (node.right != null ? "Key => " + node.right.key + ", Value => " + node.right.data : "null"));
        display(node.left);
        display(node.right);
    }

}

/**
 * Smart Priority Queue class implementation
 */
class SmarterPQ {
    Tree tree;

    /**
     * Constructor of SmarterPQ class taking heap type as the parameter
     *
     * @param isMaxHeap
     */
    SmarterPQ(boolean isMaxHeap) {
        tree = new Tree(isMaxHeap);
    }

    /**
     * Method to insert key value pairs in the priority queue
     *
     * @param key  of type int
     * @param data of type Object(allows any type )
     */
    void insert(int key, Object data) {
        tree.insert(key, data);
        tree.size++;
    }

    /**
     * Method to return the size of smart priority queue
     *
     * @return Size of queue
     */
    int size() {
        return tree.size;
    }

    /**
     * Checks whether the priority queue is empty
     *
     * @return boolean value
     */
    boolean isEmpty() {
        return tree.size == 0;
    }

    /**
     * Checks the state if it is a Max Heap or a Min Heap
     *
     * @return string about the state
     */
    String state() {
        return tree.isMaxHeap ? "Max Heap" : "Min Heap";
    }

    /**
     * It uses the display function to display the tree
     */
    void display() {
        tree.display(tree.root);
    }

    /**
     * Method to toggle the heap between Min or Max
     */
    void toggle() {
        tree.isMaxHeap = !tree.isMaxHeap;
        heapUp(tree.root);
    }

    /**
     * Method that starts from the leaves and heapify each subtree bottom-up
     *
     * @param node
     */
    void heapUp(Tree.Node node) {
        if (node == null) {
            return;
        }
        // First heapify left and right subtrees
        heapUp(node.left);
        heapUp(node.right);
        // Then heapify the current node
        tree.heapify(node);
    }

    /**
     * Method to remove the top element of the priority queue
     *
     * @return the removed element
     */
    Tree.Node removeTop() {
        Tree.Node curTop = top();
        Tree.Node tempNode = new Tree.Node(curTop.key, curTop.data);

        Tree.Node toRemove = tree.root;
        deleteNode(tree.root, tree.root);
        tree.size--;
        tree.heapify(toRemove);
        return tempNode;
    }

    /**
     * Function to remove given entry from the priority Queue
     *
     * @param entry key,value pair
     * @return delete entry
     */
    Tree.Node remove(Tree.Node entry) {
        Tree.Node toRemove = tree.root;
        deleteNode(tree.root, entry);
        tree.size--;
        tree.heapify(toRemove);
        return toRemove;
    }

    /**
     * Method to delete the Node of tree
     *
     * @param root  of the Tree
     * @param entry to delete
     * @return deleted entry
     */
    public Tree.Node deleteNode(Tree.Node root, Tree.Node entry) {

        if (root == null) {
            return null;
        }
        root.right = deleteNode(root.right, entry);
        root.left = deleteNode(root.left, entry);

        if (root.key == entry.key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Tree.Node IS = findInOrderSuccessor(root.right);
            root.key = IS.key;

            root.right = deleteNode(root.right, IS);
        }

        return root;
    }

    /**
     * Method to search successor of the root node
     *
     * @param root
     * @return the successor of root
     */
    private Tree.Node findInOrderSuccessor(Tree.Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Method to return the top element of the priority queue
     *
     * @return the top element
     */
    Tree.Node top() {
        return tree.root;
    }

    /**
     * Method to replace the key of the provided entry with the new key
     *
     * @param entry
     * @param newKey
     * @return old key
     */
    int replaceKey(Tree.Node entry, int newKey) {
        if (entry == null) return -1;

        int oldKey = entry.key;
        Tree.Node nodeReplaced = replaceKeyHelper(tree.root, oldKey, newKey);
        if (nodeReplaced != null) {
            heapifySubtree(tree.root);
        }
        return oldKey;
    }

    /**
     * Method to find the node with the given key
     *
     * @param key
     * @return node with the respected key
     */
    Tree.Node findNodeByKey(int key) {
        return findNodeByKey(tree.root, key);
    }

    /**
     * Method to find the node with the given key
     *
     * @param node
     * @param key
     * @return node with the respected key
     */
    private Tree.Node findNodeByKey(Tree.Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        }
        Tree.Node left = findNodeByKey(node.left, key);
        if (left != null) {
            return left;
        }
        return findNodeByKey(node.right, key);
    }

    /**
     * Method to replace the data value of the provided entry with the new data value
     *
     * @param entry
     * @param newValue
     * @return old value
     */
    Object replaceValue(Tree.Node entry, Object newValue) {
        int key = entry.key;
        return replaceValue(tree.root, key, newValue);
    }

    /**
     * Method to replace the data value of the provided entry with the new data value
     *
     * @param node
     * @param key
     * @param newValue
     * @return old value
     */
    private Object replaceValue(Tree.Node node, int key, Object newValue) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            Object oldValue = node.data;
            node.data = newValue;
            return oldValue;
        }
        Object leftResult = replaceValue(node.left, key, newValue);
        if (leftResult != null) {
            return leftResult;
        }
        return replaceValue(node.right, key, newValue);
    }

    /**
     * Method to heapify left and right subtree
     *
     * @param node
     */
    void heapifySubtree(Tree.Node node) {
        if (node == null) return;
        heapifySubtree(node.left);
        heapifySubtree(node.right);
        tree.heapify(node);
    }

    /**
     * Helper method to replace the key
     *
     * @param node
     * @param oldKey
     * @param newKey
     * @return replaced node
     */
    private Tree.Node replaceKeyHelper(Tree.Node node, int oldKey, int newKey) {
        if (node == null) return null;

        if (node.key == oldKey) {
            node.key = newKey;
            return node;
        }

        Tree.Node leftResult = replaceKeyHelper(node.left, oldKey, newKey);
        if (leftResult != null) return leftResult;

        return replaceKeyHelper(node.right, oldKey, newKey);
    }


}