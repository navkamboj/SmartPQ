import java.util.Scanner;

/*
4 orange
7 apple
3 grape
9 dragon
6 peaches
1 watermelon
10 onion
14 kiwi
5 singhara
2 plum
done
 */

public class Example7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmarterPQ queue = new SmarterPQ(false);
        System.out.println("-----------------Welcome to Smart Priority Queue----------------");
        System.out.println("Enter the nodes of the SmartPQ:");
        while (true) {
            String temp = sc.nextLine();
            if (temp.equals("done")) {
                break;
            }
            String[] arrStr = temp.split(" ");
            queue.insert(Integer.parseInt(arrStr[0]), arrStr[1]);
        }
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println("The state of the priority queue :" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        System.out.println("Entering new element with key: 15 and value: banana");
        queue.insert(15, "banana");
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        Tree.Node nodeToRemove = queue.findNodeByKey(4);
        System.out.println("Removing the node with key: "+nodeToRemove.key );
        queue.tree.root = queue.remove(nodeToRemove);
        System.out.println("The size of the priority queue: " + queue.size());
        queue.display();
        System.out.println("Entering new element with key: 11 and value: melon");
        queue.insert(11, "melon");
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        Tree.Node nodeToRemove1 = queue.findNodeByKey(11);
        System.out.println("Removing the node with key: "+nodeToRemove1.key );
        queue.tree.root = queue.remove(nodeToRemove1);
        queue.display();
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        Tree.Node nodeToRemove2 = queue.findNodeByKey(2);
        System.out.println("Removing the node with key: "+nodeToRemove2.key );
        queue.tree.root = queue.remove(nodeToRemove2);
        queue.display();
    }
}
