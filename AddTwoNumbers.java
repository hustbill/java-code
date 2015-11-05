/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;



public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null)  return l2;
        if (l2 == null)  return l1;
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        int tmp = 0;
        
        while ( l1 != null || l2 != null  || tmp !=0) {
            if(l1 != null) {
                tmp =+ l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(tmp %10);
            p = p.next;
            // Refer to : https://leetcode.com/discuss/57518/java-solution-concise-and-easy-to-understand
            // Java solution -- concise and easy to understand
            tmp = tmp/10;   // if tmp >10,  create a new node with carry
        }
        printList(head.next);
        
        return head.next;
    }

    // fail for this case 
    /*
    [9]
    [1,9,9,9,9,9,9,9,9,9]
    Expected answer:  [0,0,0,0,0,0,0,1]
        
    */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res ;
        int i =0, j=0;
        int left = 0,  right =0;
        if (l1 == null)  return l2;
        if (l2 == null)  return l1;
        while(l1 != null) {
            left += l1.val  * Math.pow(10, i);
            l1 = l1.next; 
            i++;
        }

        while(l2 != null) {
            right += l2.val  * Math.pow(10, j);
            l2 = l2.next; 
            j++;
        }

        int sum = left + right;
        String s = Integer.toString(sum);
        String reverse = new StringBuffer(s).reverse().toString();
         
        int[] intArray = new int[reverse.length()];

        ListNode head = new ListNode(0);
        ListNode p = head;
         
        for(i=0;i<reverse.length();i++) {
            intArray[i] = Integer.parseInt(String.valueOf(reverse.charAt(i)));
            p.next = new ListNode(intArray[i]);
            p = p.next;
        }

        return head.next;

    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l7 = new ListNode(1);
        
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;
        
        ListNode l2 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l2.next = l4;
        l4.next = l6;
        
        ListNode res = addTwoNumbers(l1, l2);
        
        printList(res);
    }
    
    public static void printList(ListNode res) {
        while(res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }         
        System.out.println();
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}