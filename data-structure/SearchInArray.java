// binary search
import java.util.*;

public class SearchInArray {
    public static void main(String[] args) {
        Integer[] nums = {1 , 9, 12 , 2, 3, 8, 6, 7, 4 , 10 ,5 ,11};
        List<Integer> list =  new ArrayList<Integer>();
        list = Arrays.asList(nums);
        
        List<Integer> sortedList = mergeSort(list);
        System.out.print(sortedList);
        
        // binary search for a target in sorted array
        int target = 11;
        System.out.printf("\nFind a target %d in sorted list\n", target);
        System.out.println(binarySearch(sortedList, target));
        
    }
    // Note : the subList method on List takes two parameters, from and to :
    // from is inclusive, and to is exclusive
    public static boolean binarySearch(List<Integer> list, int target) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        
        final int mid = list.size() / 2;
        final int comparison = list.get(mid);
        
        if (target == comparison) {
            return true;
        }
        
        if (target < comparison) {
            return binarySearch(list.subList(0, mid), target);
        } else {
            return binarySearch(list.subList(mid, list.size()), target);
        }
        
    }
    
    // Time complexity - O(nlogn)
    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int midIndex = list.size() / 2;
        
        List<Integer> leftList = list.subList(0, midIndex);
        List<Integer> rightList = list.subList(midIndex, list.size());
        
        return merge(mergeSort(leftList), mergeSort(rightList)); 
    }
    
    // O(N)
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