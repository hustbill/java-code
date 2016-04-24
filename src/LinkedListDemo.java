import java.util.*;

public class LinkedListDemo {

   public static void main(String[] args) {

   // create a LinkedList
   LinkedList list = new LinkedList();

   // add some elements
   list.add("Hello");
   list.add(2);
   list.add("Chocolate");
   list.add("10");

   // print the list
   System.out.println("LinkedList:" + list);

   // retrieve and remove the first element of the list
   System.out.println("First element of the list:" + list.pollFirst());

   // print the list
   System.out.println("LinkedList:" + list);
   }
}