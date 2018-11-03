package com.zerozzl.study.java.designpatterns;

/**
 * 代理
 */
public class Proxy {

	interface Subject {
		void request();
	}

	class RealSubject implements Subject {
		@Override
		public void request() {
			System.out.println("RealSubject do request");
		}
	}
	
	class proxy implements Subject {
		private RealSubject realSubject;

		public proxy(
				RealSubject rs) {
			this.realSubject = rs;
		}

		@Override
		public void request() {
			System.out.println("Proxy do request");
			this.realSubject.request();
		}
	}

	public static void main(String[] args) {
		Proxy self = new Proxy();
		proxy proxy = self.new proxy(self.new RealSubject());
		proxy.request();
	}

}
