package com.zerozzl.study.designpatterns;

/**
 * 责任链
 */
public class ChainOfResponsibility {

	abstract class Handler {
		protected String name;
		protected Handler nextHandler;

		public abstract void handleRequest(String name);

		public Handler(
				String name) {
			this.name = name;
		}

		public Handler getNextHandler() {
			return nextHandler;
		}

		public void setNextHandler(Handler nextHandler) {
			this.nextHandler = nextHandler;
		}
	}

	class ConcreteHandler extends Handler {
		public ConcreteHandler(
				String name) {
			super(name);
		}

		@Override
		public void handleRequest(String name) {
			if (this.name.equals(name)) {
				System.out.println(this.name + " handle request");
			} else {
				System.out.println(this.name + " pass request");
				if (getNextHandler() != null) {
					getNextHandler().handleRequest(name);
				} else {
					System.out.println("request can not handle");
				}
			}
		}
	}

	public static void main(String[] args) {
		ChainOfResponsibility self = new ChainOfResponsibility();
		Handler handler1 = self.new ConcreteHandler("handler1"), handler2 = self.new ConcreteHandler("handler2"),
				handler3 = self.new ConcreteHandler("handler3");
		handler2.setNextHandler(handler3);
		handler1.setNextHandler(handler2);
		handler1.handleRequest("handler4");
	}

}
