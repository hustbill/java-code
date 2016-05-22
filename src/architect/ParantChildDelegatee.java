package architect;

/*
 * to constrcut Parent.
to construct Delegatee.
to construct Child.
构造一个类时，它的父类和成员变量所属类的构造函数都会被自动执行，
具体顺序时先Parent 再 Delegatee 最后child
page 305  软件架构设计 温昱
 */
public class ParantChildDelegatee {

	public ParantChildDelegatee() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
	}
}

class Parent {
	Parent() {
		System.out.println("to constrcut Parent.");
	}
}

class Child extends Parent {
	Child() {
		System.out.println("to construct Child.");
	}
	
	Delegatee delegatee = new Delegatee();
}

class Delegatee {
	Delegatee() {
		System.out.println("to construct Delegatee.");
	}
}