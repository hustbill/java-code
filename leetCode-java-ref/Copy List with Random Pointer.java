/* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.*/

/*solve the question in 3 steps:
1. insert new duplicate listnode
2. copy the random pointer
3. divide into two independant list.*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null==head)
            return head;
        RandomListNode cur=head;
        /*copy listnode*/
        while(null!=cur){
            RandomListNode tmp=new RandomListNode(cur.label);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=tmp.next;
        }
        /*copy random pointer*/
        cur=head;
        while(null!=cur){
            RandomListNode tmp=cur.next;
            if(null!=cur.random)
                tmp.random=cur.random.next;
            cur=tmp.next;
        }
        /*divide the list*/
        cur=head;
        RandomListNode dup= head.next;
        RandomListNode tmp=cur.next;
        while(null!=cur && null!=tmp){
            cur.next=tmp.next;
            cur=tmp.next;
            if(null!=tmp.next){
                tmp.next=tmp.next.next;
                tmp=tmp.next;
            }
            
        }
        return dup;
    }
}
