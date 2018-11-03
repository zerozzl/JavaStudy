package com.zerozzl.study.java.designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元
 */
public class Flyweight {

	interface flyweight {
		public void operation(String outerState);
	}

	class ConcreteFlyweight implements flyweight {
		private String innerState;

		public ConcreteFlyweight(
				String innerState) {
			this.innerState = innerState;
		}

		public void operation(String outerState) {
			System.out.println("inner: " + innerState + ", outer: " + outerState);
		}
	}

	class UnsharedConcreteFlyweight implements flyweight {
		public void operation(String outerState) {
			System.out.println("outer: " + outerState);
		}
	}

	class FlyweightFactory {
		private Map<String, flyweight> pool = new HashMap<String, flyweight>();

		public flyweight getFlyweight(String innerState) {
			if (pool.get(innerState) == null) {
				pool.put(innerState, new ConcreteFlyweight(innerState));
			}
			return pool.get(innerState);
		}
	}

	public static void main(String[] args) {
		Flyweight self = new Flyweight();
		FlyweightFactory factory = self.new FlyweightFactory();

		flyweight fly1 = factory.getFlyweight("1");
		fly1.operation("a");

		flyweight fly2 = factory.getFlyweight("1");
		fly2.operation("b");

		flyweight fly3 = factory.getFlyweight("2");
		fly3.operation("a");
	}

}
