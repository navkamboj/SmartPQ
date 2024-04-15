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
public class Example1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmarterPQ queue = new SmarterPQ(false);
        System.out.println("-----------------Welcome to Smart Priority Queue----------------");
        System.out.println("Enter the nodes of the SmartPQ:");
        while (true){
            String temp = sc.nextLine();
            if(temp.equals("done")){
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
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println();
        System.out.println("Removing the top node");

        Tree.Node removedNode = queue.removeTop();

        System.out.println("Top Node removed : Key "+ removedNode.key + " Value: "+removedNode.data  );
        System.out.println();

        Tree.Node nodeToRemove = queue.findNodeByKey(4);
        System.out.println("Removing the node with key "+nodeToRemove.key );
        queue.tree.root = queue.remove(nodeToRemove);
        queue.display();
        System.out.println("The size of the priority queue: " + queue.size());

        System.out.println();
        System.out.println("Displaying the top element: Key: "+ queue.top().key +" Value: "+queue.top().data);

        System.out.println();
        System.out.println("Is Smart priority Queue Empty ? "+ queue.isEmpty());

        System.out.println();

        replaceKeyCall(queue);
        System.out.println();
        replaceValueCall(queue);

    }

    static private void replaceKeyCall(SmarterPQ queue){

        Tree.Node nodeToReplace = queue.findNodeByKey(1);


        if (nodeToReplace != null) {
            int newKey = 15;
            System.out.println("Replace key of entry : Key => " +nodeToReplace.key+" with new Key => "+ newKey );
            int oldKey = queue.replaceKey(nodeToReplace, newKey);

            System.out.println("Old key: " + oldKey);
            queue.display();
        } else {
            System.out.println("Node with key " +nodeToReplace.key+ " not found.");
        }
    }

    static private void replaceValueCall(SmarterPQ queue){


        int key = 15;
        Tree.Node nodeToReplace2 = queue.findNodeByKey(key);
        if (nodeToReplace2 != null) {
            Object newValue = "xxx";
            System.out.println("Replacing old value with new Value "+newValue);
            Object oldValue = queue.replaceValue(nodeToReplace2, newValue);
            System.out.println("Old Value: " + oldValue);
            queue.display();
        } else {
            System.out.println("Node with key "+key+" not found.");
        }
    }
}
