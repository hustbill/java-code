package phone;
//You are given two lists. Write a method that checks for duplicate elements in the second list.
// test cases :
// listA: [1,2,3,4]
// listB: [3,6,8.5]
// 
// invalidList: [1,2,3,3]
// hasDupliactes(listA, listB) -> true
//boolean
// list sorted?
// O(lenA * LenB)

// hashset 

// sort A , sort B
// and do binary search 
// O(logn)

// hashset

// set   add List A into set , no duplicate in list A
//  continue add ListB into set , if duplicate one , set will failed.  return false
// O(len A + len B) 


// use two LinkedHashSet 

// Add list A into  set 1  
// Add list B into set 2
// Add element from set2 into set 1
import java.util.*;
import java.util.HashSet;

public class FindDuplicateInTwoArrays {
    public static void main(String[] args) {
        Integer[] array1 = { 9, 2, 1, 8};
        Integer[] array2 = {3, 6, 8, 5};
        FindDuplicateInTwoArrays finder = new FindDuplicateInTwoArrays();
        System.out.println(finder.checkDuplicate(array1, array2));
        System.out.println(finder.checkDuplicatSingleSet(array1, array2));
        
        System.out.println(finder.findDuplicate(array1, array2));
    }
    
    public boolean checkDuplicate(Integer[] array1, Integer[] array2) {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(array1));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(array2));
        // if set2.size() > set1.size()
        
        for (int element : set2) {
            if (!set1.add(element)) {
                return true;
            }
        }
        return false;
    }
    
     public boolean checkDuplicatSingleSet(Integer[] array1, Integer[] array2) {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(array1));
        for (int element : array2) {
            if (!set1.add(element)) {
                return true;
            }
        }
        return false;
    }
    
    // second solution
    // two pointer - failed;
    //         Integer[] array1 = { 9, 2, 1, 8};
    //         Integer[] array2 = {3, 6, 8, 5};
    public boolean findDuplicate(Integer[] A, Integer[] B) {
        int pointerA = 0; // point to A;
        int pointerB = 0;  // point to B;
    
        
        while(pointerA < A.length && pointerB < B.length) {
            if (A[pointerA] == B[pointerB] ) {
               return true;
            } else if ( A[pointerA] < B[pointerB]) {
                pointerA++;
            } else {
                pointerB++;
            }
        }
        return false;
    }
}
