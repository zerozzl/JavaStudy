package com.zerozzl.study.designpatterns;

/**
 * 桥接
 */
public class Bridge {

	interface Implementor {
		void Operation();
	}

	class ConcreteImplementorA implements Implementor {
		public void Operation() {
			System.out.println("ConcreteImplementorA Operation");
		}
	}

	class ConcreteImplementorB implements Implementor {
		public void Operation() {
			System.out.println("ConcreteImplementorB Operation");
		}
	}
	
	class Abstraction {
		protected Implementor implementor;

		public void Operation() {
			implementor.Operation();
		}

		public void setImplementor(Implementor impl) {
			this.implementor = impl;
		}
	}

	class RefinedAbstraction extends Abstraction {
		@Override
		public void Operation() {
			System.out.println("RefinedAbstraction");
			implementor.Operation();
		}
	}

	public static void main(String[] args) {
		Bridge self = new Bridge();
		Abstraction abstraction = self.new RefinedAbstraction();
		abstraction.setImplementor(self.new ConcreteImplementorA());
		abstraction.Operation();

		abstraction.setImplementor(self.new ConcreteImplementorB());
		abstraction.Operation();
	}

}
