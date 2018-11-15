package com.zerozzl.study.designpatterns;

/**
 * 工厂方法
 */
public class FactoryMethod {

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

	interface Factory {
		Product createProduct();
	}

	class Factory1 implements Factory {
		public Product createProduct() {
			return new Product1();
		}
	}

	class Factory2 implements Factory {
		public Product createProduct() {
			return new Product2();
		}
	}

	public static void main(String[] args) {
		FactoryMethod self = new FactoryMethod();
		Factory factory = self.new Factory1();
		Product prod = factory.createProduct();
		prod.run();
	}
}
