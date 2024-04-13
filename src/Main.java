public class Main {
    public static void main(String[] args) {
        // Create an instance of SmarterPriorityQueue
        SmarterPQ spq = new SmarterPQ();

        // Insert some elements into the priority queue
        SmarterPQ.Node entry1 = spq.insert(10, "Value1");
        SmarterPQ.Node entry2 = spq.insert(5, "Value2");
        SmarterPQ.Node entry3 = spq.insert(15, "Value3");
        SmarterPQ.Node entry4 = spq.insert(3, "Value4");

        // Print the current state of the priority queue
        System.out.println("Current state: " + spq.state()); // Output: Min

        // Toggle between min and max heaps
        spq.toggle();

        // Print the current state after toggling
        System.out.println("Current state after toggle: " + spq.state()); // Output: Max

        // Remove the top element
        SmarterPQ.Node removedNode = spq.removeTop();
        System.out.println("Removed top element: (" + removedNode.key + ", " + removedNode.value + ")");

        // Print the top element without removing it
        SmarterPQ.Node topNode = spq.top();
        System.out.println("Top element: (" + topNode.key + ", " + topNode.value + ")");

        // Check if the priority queue is empty
        System.out.println("Is empty? " + spq.isEmpty()); // Output: false

        // Replace the key of an entry
        int oldKey = spq.replaceKey(entry2, 20);
        System.out.println("Old key of entry2: " + oldKey);
        SmarterPQ.Node newTopNode = spq.top();
        System.out.println("New top element after replacing key: (" + newTopNode.key + ", " + newTopNode.value + ")");
    }
}
