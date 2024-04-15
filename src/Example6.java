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

public class Example6 {
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
        removeValueCall(queue);
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        removeValueCall1(queue);
    }

    static private void removeValueCall(SmarterPQ queue){


        int key = 3;
        Tree.Node nodeToReplace2 = queue.findNodeByKey(key);
        if (nodeToReplace2 != null) {
            Object newValue = "guava";
            System.out.println("Replacing old value with new Value "+newValue);
            Object oldValue = queue.replaceValue(nodeToReplace2, newValue);
            System.out.println("Old Value: " + oldValue);
            queue.display();
        } else {
            System.out.println("Node with key "+key+" not found.");
        }
    }
    static private void removeValueCall1(SmarterPQ queue){


        int key = 5;
        Tree.Node nodeToReplace2 = queue.findNodeByKey(key);
        if (nodeToReplace2 != null) {
            Object newValue = "strawberry";
            System.out.println("Replacing old value with new Value "+newValue);
            Object oldValue = queue.replaceValue(nodeToReplace2, newValue);
            System.out.println("Old Value: " + oldValue);
            queue.display();
        } else {
            System.out.println("Node with key "+key+" not found.");
        }
    }
}
