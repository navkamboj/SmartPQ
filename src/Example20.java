import java.util.Scanner;

/*
1 10
2 20
5 50
4 40
3 30
done
 */
public class Example20 {
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

        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println();
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
    }
}
