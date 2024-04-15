import java.util.Scanner;

/*
done
 */

public class Example8 {
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
        System.out.println("Is the priority queue empty?: " + queue.isEmpty());
        System.out.println("The state of the priority queue :" + queue.state());
        System.out.println("Entering new element with key: 15 and value: banana");
        queue.insert(15, "banana");
        System.out.println("Is the priority queue empty?: " + queue.isEmpty());
        System.out.println("Toggling the state of the PQ");
        queue.toggle();
        System.out.println("The state of the priority queue:" + queue.state());
        System.out.println("The size of the priority queue: " + queue.size());
        queue.display();
        System.out.println("Entering new element with key: 11 and value: melon");
        queue.insert(11, "melon");
        System.out.println("The size of the priority queue: " + queue.size());
        System.out.println("Displaying the SmartPQ");
        System.out.println("----------------------");
        queue.display();
        System.out.println("Is the priority queue empty?: " + queue.isEmpty());
    }
}
