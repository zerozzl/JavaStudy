package com.zerozzl.study.java.designpatterns;

/**
 * 生成器
 */
public class Builder {

	class Product {
		private String partA;
		private String partB;
		private String partC;

		public void setPartA(String partA) {
			this.partA = partA;
		}

		public void setPartB(String partB) {
			this.partB = partB;
		}

		public void setPartC(String partC) {
			this.partC = partC;
		}

		public void run() {
			System.out.println("PartA: " + partA);
			System.out.println("PartB: " + partB);
			System.out.println("PartC: " + partC);
		}

	}

	abstract class builder {
		public abstract void buildPartA();

		public abstract void buildPartB();

		public abstract void buildPartC();

		public abstract Product getProduct();
	}

	class ConcreteBuilder extends builder {

		private Product prod = new Product();

		public void buildPartA() {
			prod.setPartA("A");
		};

		public void buildPartB() {
			prod.setPartB("B");
		};

		public void buildPartC() {
			prod.setPartC("C");
		}

		@Override
		public Product getProduct() {
			return this.prod;
		};
	}

	class Director {
		public void construct(builder bul) {
			bul.buildPartA();
			bul.buildPartB();
		}
	}

	public static void main(String[] args) {
		Builder self = new Builder();
		ConcreteBuilder builder = self.new ConcreteBuilder();
		Director director = self.new Director();
		director.construct(builder);
		Product product = builder.getProduct();
		product.run();
	}

}
