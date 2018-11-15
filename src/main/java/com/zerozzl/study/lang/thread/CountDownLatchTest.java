package com.zerozzl.study.lang.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	class Waiter implements Runnable {

		CountDownLatch latch = null;

		public Waiter(
				CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Waiter Released");
		}
	}

	class Decrementer implements Runnable {

		CountDownLatch latch = null;

		public Decrementer(
				CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {

			try {
				Thread.sleep(1000);
				this.latch.countDown();

				Thread.sleep(1000);
				this.latch.countDown();

				Thread.sleep(1000);
				this.latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatchTest self = new CountDownLatchTest();
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter = self.new Waiter(latch);
		Decrementer decrementer = self.new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}

}
