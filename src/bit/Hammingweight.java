package bit;

public class Hammingweight {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}
	
    // https://en.wikipedia.org/wiki/Hamming_weight
    public int hammingWeight_Wrong(int n) {
        // failed at this case:  2147483648 (10000000000000000000000000000000)  -> 1
    	//       public int hammingWeight(int n) {
        // https://leetcode.com/discuss/30605/simple-java-solution-bit-shifting
        int count = 0;
        for (;n!=0;n = n & (n-1))
            count++;
        return count;
   }
    
	public static void main(String[] args) {
		int n = 11;
		Hammingweight hw = new Hammingweight();
		System.out.println(hw.hammingWeight(n));
	}

}
