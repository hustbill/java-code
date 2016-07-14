package ood;

import java.util.*;

public class ClassABTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassA a = new ClassB();
		a.func1(); //
		
		/*
		 *  class A , class B 如果 func1()  是static的  ， 则 a.func1() 调用的是 classA 中的 func1() 。 反之，则调用 classB中的func1()
		 */
		
		//ClassB b = new ClassA();  // failed.   HashMap<Integer> hashmap = new Map<Integer>()  是不对的
		// b.func1(); //
		
		 // HashMap<Integer> hashmap = new Map<Integer>()；
		/*
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	Incorrect number of arguments for type HashMap<K,V>; it cannot be parameterized with arguments <Integer>
	Incorrect number of arguments for type Map<K,V>; it cannot be parameterized with arguments <Integer>
	Syntax error on token "Invalid Character", ; expected
		 */
		
	}
	

}
