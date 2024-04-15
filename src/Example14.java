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
public class Example14 {
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

        System.out.println("The state of the priority queue :" + queue.state());
        System.out.println();


        System.out.println("Is Smart priority Queue Empty ? "+ queue.isEmpty());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();


        System.out.println();
        System.out.println("Displaying the top element: Key: "+ queue.top().key +" Value: "+queue.top().data);

        System.out.println("Removing the top node");

        Tree.Node removedNode = queue.removeTop();

        System.out.println("Top Node removed : Key "+ removedNode.key + " Value: "+removedNode.data  );
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
    }
}
