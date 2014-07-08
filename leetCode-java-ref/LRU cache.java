/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it 
should invalidate the least recently used item before inserting a new item.*/

/*The data structure used in the cache is HashMap and double linked list. The HashMap can check whether the cache contains
a key in O(1) time, while double linked list can insert and delete a node in O(1) time. */

public class LRUCache {
    private int capacity;
    private int len;
    private doubleLinkedListNode head;
    private doubleLinkedListNode end;
    HashMap<Integer,doubleLinkedListNode> map=new HashMap<Integer,doubleLinkedListNode>();
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        len=0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            doubleLinkedListNode node=map.get(key);
            removeNode(node);
            setHeadNode(node);
            return node.val;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            doubleLinkedListNode oldNode=map.get(key);
            oldNode.val=value;
            removeNode(oldNode);
            setHeadNode(oldNode);
        }
        else{
            doubleLinkedListNode node=new doubleLinkedListNode(key,value);
            if(len<capacity){
                setHeadNode(node);
                map.put(key,node);
                len++;
            }
            else{
                map.remove(end.key);
                end=end.pre;
                if(null!=end)
                    end.next=null;
                map.put(key,node);
                setHeadNode(node);
            }
        }
    }
    public void setHeadNode(doubleLinkedListNode node){
        node.next=head;
        node.pre=null;
        if(null!=head)
            head.pre=node;
        head=node;
        if(null==end)
            end=node;
    }
    public void removeNode(doubleLinkedListNode node){
        doubleLinkedListNode preNode=node.pre;
        doubleLinkedListNode nextNode=node.next;
        if(null!=preNode){
            preNode.next=nextNode;
        }
        else{
            head=nextNode;
        }
        if(null!=nextNode){
            nextNode.pre=preNode;
        }
        else{
            end=preNode;
        }
    }
}
class doubleLinkedListNode{
    public int key;
    public int val;
    public doubleLinkedListNode pre;
    public doubleLinkedListNode next;
    public doubleLinkedListNode(int k, int value){
        key=k;
        val=value;
    }
}
