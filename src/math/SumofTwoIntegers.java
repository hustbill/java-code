package math;

public class SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofTwoIntegers st = new SumofTwoIntegers();
		System.out.println(st.getSum(3, 2));
	}
	
	public int getSum(int a, int b) {
		
		// a = 3, b = 2,  
		// a- > 0011, b-> 0010
		// sum -> 0101
		
		while ( b!= 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
				
	}
	
	public int getSumNotWork(int a, int b) {
        // convert a to bits  e.g. 3 to 11
        String stra = Integer.toBinaryString(a);

        System.out.println(stra);
        // convert b to bits  e.g. 2 to 10
        String strb = Integer.toBinaryString(b);
        System.out.println(strb);
        
        
        //
    
        
        return Integer.valueOf(stra);
    }

}
