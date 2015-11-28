import java.util.*;

public class MergeKLists {
    
    public static Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override public int compare(ListNode x, ListNode y) {
            return x.val - y.val;
        }
    };
    public static ListNode mergeKLists(List<ListNode> lists) {
        /* Ref :  下面的解法，和leetcode clean code handbook v1.03 上是一致的。 但是加了注释。更加好懂。
         http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
         We could use a min heap of size k. The heap is first initialized with the smallest element
		from each list. Then as we extract the nodes out from the heap, we must remember to
		insert its next node into the heap. As each insert operation into the heap costs log(k) and
		there are a total of nk elements, the total runtime complexity is O(nk log k).
		Ignoring the extra space that is used to store the output list, we only use extra space of
		O(k) due to the heap.
        */
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>( lists.size(), comparator);
        for (ListNode node : lists) {
            if (node != null)
                q.add(node);
        }
    
        ListNode  head = new ListNode(0);
        ListNode p = head;  // serve as a pointer /cursor
        
        while ( q.size() > 0) {
            ListNode temp = q.poll(); // poll () retrieves and removes the head of the queue -q.
            p.next = temp;
            
            if (temp.next != null) // keep adding next element of each list
                q.add(temp.next);
            
           p  = p.next;
        }

        return head.next;
        
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        
        l1.next = l4;
        l2.next = l5;
        l3.next = l6;
        l6.next = l7;
        
        List<ListNode> inputList = new ArrayList<ListNode>();
        inputList.add(l1);
        inputList.add(l2);
        inputList.add(l3);
        
        ListNode head = mergeKLists(inputList);
        while(head != null) {
            System.out.printf (" %d ", head.val);
            head = head.next;
        }
            
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}