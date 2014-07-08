/* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.*/

/* The line could be described by y=kx+b, every two points can determine the k and b, so we use a hashmap to store all
 the slopes and non-duplicate points on the line, then add the duplicates at last. 
 The details: the second loop can start from current one, j=i+1
 hashmap put k=Integer.MAX_VALUE first, in case all the points are the same
 k=0.0+slope, in case -.0.0 is different from 0.0*/
 
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(null==points || 0==points.length)
            return 0;
        int res=1;
        HashMap<Double,Integer> map=new HashMap<Double,Integer>();
        for(int i=0;i<points.length;++i){
            map.clear();
            int dup=0;
            map.put((double)Integer.MAX_VALUE,1);
            for(int j=i+1;j<points.length;++j){
                if(points[j].y==points[i].y && points[j].x==points[i].x){
                    dup++;
                    continue;
                }
                double slope= points[j].x == points[i].x ? Integer.MAX_VALUE : 0.0+(double)(points[j].y-points[i].y)/
                (double)(points[j].x-points[i].x);
                if(map.containsKey(slope))
                    map.put(slope,map.get(slope)+1);
                else
                    map.put(slope,2);
            }
            for(int temp:map.values()){
                if(temp+dup>res)
                    res=temp+dup;
            }
        }
        return res;
    }
}
