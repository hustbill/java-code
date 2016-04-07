// binary search
import java.util.*;

public class SearchInArray {
    public static void main(String[] args) {
        Integer[] nums = {1 , 9, 12 , 2, 3, 8, 6, 7, 4 , 10 ,5 ,11};
        List<Integer> list =  new ArrayList<Integer>();
        list = Arrays.asList(nums);
        System.out.print(mergeSort(list));
    }
    
    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int midIndex = list.size() / 2;
        
        List<Integer> leftList = list.subList(0, midIndex);
        List<Integer> rightList = list.subList(midIndex, list.size());
        
        return merge(mergeSort(leftList), mergeSort(rightList)); 
    }
    
    public static List<Integer> merge(List<Integer> l,  List<Integer> r) {
        int leftPtr = 0, rightPtr = 0;        
        List<Integer> toReturn = new ArrayList<>();
        
        while ( leftPtr < l.size() && rightPtr < r.size()) {
            if (l.get(leftPtr) < r.get(rightPtr)) {
                toReturn.add(l.get(leftPtr));
                leftPtr++;
            } else {
                toReturn.add(r.get(rightPtr));
                rightPtr++;
            }
        }
        
        while (leftPtr < l.size()) {
            toReturn.add(l.get(leftPtr));
            leftPtr++;
        }
        
        while (rightPtr < r.size()) {
            toReturn.add(r.get(rightPtr));
            rightPtr++;
        }

        return toReturn;
    }
}