/*
 * 
 */
package jvm;

import java.util.*;


public class ReferenceTest {
	 
    public static final Map<Integer, Reference> map = new HashMap<Integer, Reference>();
 
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            map.put(i, new WeakReference(new ReferenceObject(i)));
        }
 
        int i = 0;
        for (Reference r : map.values()) {
            if (r.get() == null) {
                i++;
            }
        }
        System.out.println("被回收的对象数:" + i);
    }
 
    static class ReferenceObject {
        private int    i;
 
        private byte[] b;
 
        public ReferenceObject(int i) {
            this.i = i;
            b = new byte[1024 *10];
        }
    }
}
