/* 
 * A Programmer's Guide to Java Certification: A Comprehensive Primer, Volume 1
 */
public class Qcb90 {

	int a;
	int b;
	public void f() {
		a = 0;
		b = 0;
		int[] c = {0};
		g(b,c);
		System.out.println(a + " " + b + " "  + c [0]);   // 1 , 0 , 1
	}
	
	public void g(int b, int[] c) {
		a = 1; // 修改的是全局变量
		b = 1;  //此处是局部变量 不是全局的变量
		c[0] = 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qcb90 obj = new Qcb90();
		obj.f();
	}

}
