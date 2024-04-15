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

public class Example10 {
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
        System.out.println("Removing the top node");
        Tree.Node removedNode = queue.removeTop();
        System.out.println("Top Node removed : Key "+ removedNode.key + " Value: "+removedNode.data  );
        System.out.println();
        queue.display();
        System.out.println();
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println();
        queue.display();
        System.out.println("Entering new element with key: 13 and value: spinach");
        queue.insert(13, "spinach");
        System.out.println("Removing the top node");
        Tree.Node removedNode1 = queue.removeTop();
        System.out.println("Top Node removed : Key "+ removedNode1.key + " Value: "+removedNode1.data  );
        System.out.println();
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println("Removing the top node");
        Tree.Node removedNode2 = queue.removeTop();
        System.out.println("Top Node removed : Key "+ removedNode2.key + " Value: "+removedNode2.data  );
        System.out.println();
        queue.display();
    }
}
