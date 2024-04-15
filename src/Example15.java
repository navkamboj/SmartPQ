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
public class Example15 {
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

        System.out.println("The state of the priority queue :" + queue.state());
        System.out.println();

        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();

        replaceValueCall(queue);

        System.out.println();
        replaceValueCall2(queue);



    }
    static private void replaceValueCall(SmarterPQ queue){


        int key = 7;
        Tree.Node nodeToReplace2 = queue.findNodeByKey(key);
        if (nodeToReplace2 != null) {
            Object newValue = "IamTheNewValue";
            System.out.println("Replacing old value with new Value "+newValue);
            Object oldValue = queue.replaceValue(nodeToReplace2, newValue);
            System.out.println("Old Value: " + oldValue);
            queue.display();
        } else {
            System.out.println("Node with key "+key+" not found.");
        }
    }
    static private void replaceValueCall2(SmarterPQ queue){


        int key = 700;
        Tree.Node nodeToReplace2 = queue.findNodeByKey(key);
        if (nodeToReplace2 != null) {
            Object newValue = "IamTheNewValue";
            System.out.println("Replacing old value with new Value "+newValue);
            Object oldValue = queue.replaceValue(nodeToReplace2, newValue);
            System.out.println("Old Value: " + oldValue);
            queue.display();
        } else {
            System.out.println("Node with key "+key+" not found.");
        }
    }

}
