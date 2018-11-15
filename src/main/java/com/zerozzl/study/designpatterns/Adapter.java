package com.zerozzl.study.designpatterns;

/**
 * 适配器
 */
public class Adapter {

	class Adaptee {
		public void specificRequest() {
			System.out.println("Adaptee");
		}
	}

	class Adapter1 extends Adaptee {
		public void request() {
			super.specificRequest();
		}
	}

	class Adapter2 {

		Adaptee adaptee = new Adaptee();

		public void request() {
			adaptee.specificRequest();
		}
	}

	public static void main(String[] args) {
		Adapter self = new Adapter();
		Adapter1 adapter1 = self.new Adapter1();
		Adapter2 adapter2 = self.new Adapter2();
		adapter1.request();
		adapter2.request();
	}

}
