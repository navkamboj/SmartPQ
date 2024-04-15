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

public class Example5 {
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
        removeKeyCall(queue);
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        removeKeyCall1(queue);
    }

    static private void removeKeyCall(SmarterPQ queue){

        Tree.Node nodeToReplace = queue.findNodeByKey(1);


        if (nodeToReplace != null) {
            int newKey = 8;
            System.out.println("Replace key of entry : Key => " +nodeToReplace.key+" with new Key => "+ newKey );
            int oldKey = queue.replaceKey(nodeToReplace, newKey);

            System.out.println("Old key: " + oldKey);
            queue.display();
        } else {
            System.out.println("Node with key " +nodeToReplace.key+ " not found.");
        }
    }
    static private void removeKeyCall1(SmarterPQ queue){

        Tree.Node nodeToReplace = queue.findNodeByKey(9);


        if (nodeToReplace != null) {
            int newKey = 1;
            System.out.println("Replace key of entry : Key => " +nodeToReplace.key+" with new Key => "+ newKey );
            int oldKey = queue.replaceKey(nodeToReplace, newKey);

            System.out.println("Old key: " + oldKey);
            queue.display();
        } else {
            System.out.println("Node with key " +nodeToReplace.key+ " not found.");
        }
    }
}
