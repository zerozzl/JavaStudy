package com.zerozzl.study.lang.thread;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	class ExchangerRunnable implements Runnable {
		Exchanger exchanger = null;
		Object object = null;

		public ExchangerRunnable(
				Exchanger exchanger,
				Object object) {
			this.exchanger = exchanger;
			this.object = object;
		}

		public void run() {
			try {
				Object previous = this.object;
				this.object = this.exchanger.exchange(this.object);
				System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExchangerTest self = new ExchangerTest();
		Exchanger exchanger = new Exchanger();

		ExchangerRunnable exchangerRunnable1 = self.new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable exchangerRunnable2 = self.new ExchangerRunnable(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}

}
