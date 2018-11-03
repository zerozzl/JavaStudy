package com.zerozzl.study.java.designpatterns;

/**
 * 抽象工厂
 */
public class AbstractFactory {

	interface Product1 {
		void run();
	}

	class Product1_1 implements Product1 {
		public void run() {
			System.out.println("Product1-1");
		}
	}

	class Product1_2 implements Product1 {
		public void run() {
			System.out.println("Product1-2");
		}
	}

	interface Product2 {
		void run();
	}

	class Product2_1 implements Product2 {
		public void run() {
			System.out.println("Product2-1");
		}
	}

	class Product2_2 implements Product2 {
		public void run() {
			System.out.println("Product2-2");
		}
	}

	interface Factory {
		Product1 createProduct1();

		Product2 createProduct2();
	}

	class Factory1 implements Factory {
		public Product1 createProduct1() {
			return new Product1_1();
		}

		public Product2 createProduct2() {
			return new Product2_1();
		}
	}

	class Factory2 implements Factory {
		public Product1 createProduct1() {
			return new Product1_2();
		}

		public Product2 createProduct2() {
			return new Product2_2();
		}
	}

	public static void main(String[] args) {
		AbstractFactory self = new AbstractFactory();
		Factory factory = self.new Factory1();
		Product1 prod1 = factory.createProduct1();
		Product2 prod2 = factory.createProduct2();
		prod1.run();
		prod2.run();
	}
}
