/*
You’ve got a text file that contains x,y,z-coordinate points for every star in the sky (on the order of 1 billion (this is N)). I want to know the 100 (or K) closest stars to earth, how would you compute that? 
earth = 0, 0, 0

*/
import java.util.*;

public class KthClosestStarFinder{

    public static Star findClosest(Star[] sky, int k) {
        PriorityQueue<Star> pq = new PriorityQueue<Star>();

        int N = sky.length;
        if (N <= k) return sky[N-1];

        for (int i = 0; i < k; i++)
            pq.add(sky[i]);

        for (int i = k; i < N; i++) {
            Star mystar = sky[i];
            if (mystar.compareTo(pq.peek()) < 0) {
                pq.remove();
                pq.add(mystar);
            }
        }
        return pq.peek();
    }
    
    public static void main(String[] args) {
        int N = 1000000, k = 100;
        Star[] sky = new Star[N];
        Random random = new Random();
        
        for (int i = 0 ; i < N  ; i++) {
            sky[i] = new Star(i, 100 + random.nextInt(10000) + i  );
            //System.out.print(sky[i].getDistance() + " , ");
        }
        
        Star res = findClosest(sky, k);
        System.out.printf("The 100 closest star is: %d, distance : %.2f",
             res.getId(), res.getDistance());
    }
}


class Star implements Comparable<Star> {
    public int id;
    public float dst;
    public Star(int id, float dst) {
        this.id = id;
        this.dst = dst;
    }
    
    public int getId() {
        return id;
    }
    public float getDistance() {
        return dst;
    }

    public int compareTo(Star other) {
        if (this.dst > other.dst) 	return 1;
        if (this.dst < other.dst) 	return -1;
        return 0;
    }
}