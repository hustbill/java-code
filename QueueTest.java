   
public class QueueTest {  
   
    public static void main(String[] args) {  
       ArrayQueue queue = new ArrayQueue(5);    
   
       for (int i = 0; i < 5; i++) {  
           queue.add(i);  
       }
       System.out.println("Queue size is " + queue.size());         
       System.out.println("Queue size is empty? " +queue.isEmpty()); 
       System.out.println("Queue is full ? " + queue.isFull());  

       System.out.println("Dequeue... ");   
       while (!queue.isEmpty()) {  
           System.out.println(queue.remove());  
       }  
       System.out.println("Queue size is " + queue.size()); 
    }  
   
}  
   
class ArrayQueue {  
    private int[] queueArr;  
    private int head;  
    private int tail; 
    private int count;
   
    public ArrayQueue(int size) {  
       this.queueArr = new int[size];  
       head = 0;  
       tail = -1;  
       count = 0;
    }  
    
    /** 
     * Returns the number of elements in this queue
     */
    public int size() {
        return count;
    }
   
   
    public boolean isEmpty() {  
       return head == queueArr.length;  
    }  
   
    public boolean isFull() {  
       return queueArr.length - 1 == tail;  
    }  
   
 
    public void add(int item) {  
       if (isFull()) {  
           throw new RuntimeException("This queue is full");  
       }  
       queueArr[++tail] = item;
       count++;
    }  
    
    /** 
     * Retrieves, but does not remove, the head of this queue,
     *   or returns null if this queue is empty.
     */  
    public int peek() {  
       return queueArr[head];
    }  
   

    /** 
     * Retrieves and removes the head of this queue
     */  
    public int remove() {  
       if (isEmpty()) {  
           throw new RuntimeException("This queue is empty");  
       }
       count--;
       return queueArr[head++];  
    }  
}  