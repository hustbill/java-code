/* Given an array of integers, every element appears twice except for one. Find that single one. */

public class Solution {
    public int singleNumber(int[] A) {
        int result=0;
        for(int i=0;i<A.length;++i){
            result^=A[i];
        }
        return result;
    }
}

/* Follow up: Given an array of integers, every element appears three times except for one. Find that single one. */

/* Run a loop for all elements in array. At the end of every iteration, maintain following two values.
ones: The bits that have appeared 1st time or 4th time or 7th time .. etc.
twos: The bits that have appeared 2nd time or 5th time or 8th time .. etc.
Finally, we return the value of ‘ones’

How to maintain the values of ‘ones’ and ‘twos’?
‘ones’ and ‘twos’ are initialized as 0. For every new element in array, find out the common set bits in the new element 
and previous value of ‘ones’. These common set bits are actually the bits that should be added to ‘twos’. So do bitwise OR 
of the common set bits with ‘twos’. ‘twos’ also gets some extra bits that appear third time. These extra bits are removed 
later.
Update ‘ones’ by doing XOR of new element with previous value of ‘ones’. There may be some bits which appear 3rd time. 
These extra bits are also removed later.
Both ‘ones’ and ‘twos’ contain those extra bits which appear 3rd time. Remove these extra bits by finding out common set 
bits in ‘ones’ and ‘twos’. */

public class Solution {
    public int singleNumber(int[] A) {
        int ones=0,twos=0,common_bit_mask=0;
        for(int i=0;i<A.length;++i){
            twos=twos | (ones&A[i]);
            ones=ones^A[i];
            common_bit_mask=~(ones&twos);
            ones&=common_bit_mask;
            twos&=common_bit_mask;
        }
        return ones;
    }
}

/* For details, refer to http://www.geeksforgeeks.org/find-the-element-that-appears-once/ */
