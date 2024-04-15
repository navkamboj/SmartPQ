import java.util.Scanner;
/*
1 10
5 50
2 20
8 80
9 90
3 30
4 40
7 70
6 60
done
 */
public class Example18 {
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
        removeKeyCall(queue);

        System.out.println();
        System.out.println("The size of the priority queue: " + queue.size());
    }
    static private void removeKeyCall(SmarterPQ queue){

        Tree.Node nodeToReplace = queue.findNodeByKey(1);


        if (nodeToReplace != null) {
            int newKey = 100;
            System.out.println("Replace key of entry : Key => " +nodeToReplace.key+" with new Key => "+ newKey );
            int oldKey = queue.replaceKey(nodeToReplace, newKey);

            System.out.println("Old key: " + oldKey);
            queue.display();
        } else {
            System.out.println("Node with key " +nodeToReplace.key+ " not found.");
        }
    }
}
