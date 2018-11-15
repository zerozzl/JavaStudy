package com.zerozzl.study.designpatterns;

/**
 * 模板方法
 */
public class TemplateMethod {

	abstract class AbstractClass {
		protected abstract void primitiveOperation1();

		protected abstract void primitiveOperation2();

		public void templateMethod() {
			primitiveOperation1();
			primitiveOperation2();
		}
	}

	class ConcreteClass1 extends AbstractClass {
		@Override
		protected void primitiveOperation1() {
			System.out.println("do class 1 operation 1");
		}

		@Override
		protected void primitiveOperation2() {
			System.out.println("do class 1 operation 2");
		}
	}

	class ConcreteClass2 extends AbstractClass {
		@Override
		protected void primitiveOperation1() {
			System.out.println("do class 2 operation 1");
		}

		@Override
		protected void primitiveOperation2() {
			System.out.println("do class 2 operation 2");
		}
	}

	public static void main(String[] args) {
		TemplateMethod self = new TemplateMethod();
		AbstractClass c1 = self.new ConcreteClass1();
		AbstractClass c2 = self.new ConcreteClass2();
		c1.templateMethod();
		c2.templateMethod();
	}

}
