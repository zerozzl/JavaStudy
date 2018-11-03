package com.zerozzl.study.java.designpatterns;

/**
 * 装饰器
 */
public class Decorator {

	interface Component {
		void function();
	}

	class ConcreateComponent implements Component {
		@Override
		public void function() {
			System.out.println("Component");
		}
	}

	abstract class decorator implements Component {
		private Component component;

		public decorator(
				Component component) {
			this.component = component;
		}

		@Override
		public void function() {
			component.function();
		}

	}

	class ConcreateDecorator1 extends decorator {
		public ConcreateDecorator1(
				Component component) {
			super(component);
		}

		@Override
		public void function() {
			this.decorateFunction();
			super.function();
		}

		private void decorateFunction() {
			System.out.println("Decorator 1");
		}
	}

	class ConcreateDecorator2 extends decorator {
		public ConcreateDecorator2(
				Component component) {
			super(component);
		}

		@Override
		public void function() {
			this.decorateFunction();
			super.function();
		}

		private void decorateFunction() {
			System.out.println("Decorator 2");
		}
	}

	public static void main(String[] args) {
		Decorator self = new Decorator();
		Component component = self.new ConcreateDecorator2(self.new ConcreateDecorator1(self.new ConcreateComponent()));
		component.function();
	}

}
