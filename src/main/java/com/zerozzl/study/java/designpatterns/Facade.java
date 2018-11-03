package com.zerozzl.study.java.designpatterns;

/**
 * 外观
 */
public class Facade {

	class A {
		public void run() {
			System.out.println("A run");
		}
	}

	class B {
		public void run() {
			System.out.println("B run");
		}
	}

	class C {
		public void run() {
			System.out.println("C run");
		}
	}

	public class facade {
		private A a;
		private B b;
		private C c;

		public facade() {
			a = new A();
			b = new B();
			c = new C();
		}

		public void runAll() {
			a.run();
			b.run();
			c.run();
		}
	}

	public static void main(String[] args) {
		Facade self = new Facade();
		facade facade = self.new facade();
		facade.runAll();
	}

}
