package javase;


public class MyHashtable { 
    
    private int manyItems;//表中元素个数 
    private Object[] keys; 
    private Object[] data; 
    private boolean[] hasBeenUsed;//若索引i处存在元素，则hasBeenUsed[i]为ture，否则为false 
     
    public MyHashtable(int capacity) { 
        if(capacity <= 0) 
            throw new IllegalArgumentException("capacity is negative"); 
         
        keys = new Object[capacity]; 
        data = new Object[capacity]; 
        hasBeenUsed = new boolean[capacity]; 
    } 
     
    //hash函数 
    private int hash(Object key) { 
        return Math.abs(key.hashCode()%data.length); 
    } 
     
    //当前索引发生冲突，找下一索引 
    private int nextIndex(int i) { 
        if(i + 1 == data.length) { 
            return 0; 
        } else { 
            return i + 1; 
        } 
    } 
     
    //如果在表中找到指定的关键字，返回值为关键字的索引，否则返回-1 
    private int findIndex(Object key) { 
        int count = 0; 
        int i = hash(key); 
         
        while((count < data.length) && hasBeenUsed[i]) { 
            if(key.equals(keys[i])) { 
                return i; 
            } else { 
                count++; 
                i = nextIndex(i); 
            } 
        } 
        return -1; 
    } 
     
    public Object get(Object key) { 
        int index = findIndex(key); 
         
        if(index == -1) { 
            return null; 
        } else { 
            return data[index]; 
        } 
    } 
     
    public Object put(Object key, Object element) { 
        int index = findIndex(key); 
        Object answer; 
         
        if(index != -1) { 
            answer = data[index]; 
            data[index] = element; 
            return answer; 
        } else if(manyItems < data.length) { 
            index = hash(key); 
            while(keys[index] != null) { 
                index = nextIndex(index); 
            } 
            keys[index] = key; 
            data[index] = element; 
            hasBeenUsed[index] = true; 
            manyItems++; 
            return null; 
        } else { 
            throw new IllegalStateException("Hashtable is full!"); 
        } 
    } 
     
    public Object remove(Object key) { 
        int index = findIndex(key); 
        Object answer = null; 
         
        if(index != -1) { 
            answer = data[index]; 
            data[index] = null; 
            keys[index] = null; 
            manyItems--; 
        } 
        return answer; 
    } 
     
    public boolean contains (Object key) { 
        return (findIndex(key) != -1); 
    } 
     
    public static void main(String[] args) { 
        MyHashtable table = new MyHashtable(100); 
        table.put(1, "china"); 
        table.put(2, "美国"); 
        System.out.println(table.get(2).toString()); 
    } 
} 

//http://www.cxybl.com/html/suanfa/201110125445.html