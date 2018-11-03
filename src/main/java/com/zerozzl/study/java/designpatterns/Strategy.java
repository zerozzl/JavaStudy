package com.zerozzl.study.java.designpatterns;

/**
 * 策略
 */
public class Strategy {

	interface strategy {
		void run();
	}

	class Strategy1 implements strategy {
		public void run() {
			System.out.println("ConcreteCompositor 1");
		}
	}

	class Strategy2 implements strategy {
		public void run() {
			System.out.println("ConcreteCompositor 2");
		}
	}

	class Composition {
		strategy s = null;

		public void setStrategy(strategy s) {
			this.s = s;
		}

		public void run() {
			this.s.run();
		}
	}

	public static void main(String[] args) {
		Strategy self = new Strategy();
		strategy com1 = self.new Strategy1(), com2 = self.new Strategy2();
		Composition factory = self.new Composition();
		factory.setStrategy(com1);
		factory.run();
		factory.setStrategy(com2);
		factory.run();
	}

}
