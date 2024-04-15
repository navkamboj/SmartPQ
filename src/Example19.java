import java.util.Scanner;

/*
1 10
5 50
4 40
3 30
done
 */
public class Example19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmarterPQ queue = new SmarterPQ(true);
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
        Tree.Node nodeToRemove = queue.findNodeByKey(4);
        System.out.println("Removing the node with key "+nodeToRemove.key );
        queue.tree.root = queue.remove(nodeToRemove);
        queue.display();
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println();

        Tree.Node nodeToRemove2 = queue.findNodeByKey(3);
        System.out.println("Removing the node with key "+nodeToRemove2.key );
        queue.tree.root = queue.remove(nodeToRemove2);
        queue.display();
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println();

        Tree.Node nodeToRemove3 = queue.findNodeByKey(5);
        System.out.println("Removing the node with key "+nodeToRemove3.key );
        queue.tree.root = queue.remove(nodeToRemove3);
        queue.display();
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println();

        Tree.Node nodeToRemove4 = queue.findNodeByKey(1);
        System.out.println("Removing the node with key "+nodeToRemove4.key );
        queue.tree.root = queue.remove(nodeToRemove4);
        queue.display();
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println();

        System.out.println();
        System.out.println("Is Smart priority Queue Empty ? "+ queue.isEmpty());

    }
}
