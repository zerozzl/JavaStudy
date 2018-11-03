package com.zerozzl.study.java.designpatterns;

/**
 * 简单工厂
 */
public class SimplyFactory {

	interface Product {
		void run();
	}

	class Product1 implements Product {
		public void run() {
			System.out.println("Product1");
		}
	}

	class Product2 implements Product {
		public void run() {
			System.out.println("Product2");
		}
	}

	class Factory {
		public Product createProduct(String type) {
			Product p = null;
			if ("prod1".equals(type))
				p = new Product1();
			else if ("prod2".equals(type))
				p = new Product2();
			return p;
		}
	}

	public static void main(String[] args) {
		SimplyFactory self = new SimplyFactory();
		Factory factory = self.new Factory();
		Product prod = factory.createProduct("prod1");
		prod.run();
	}
}
