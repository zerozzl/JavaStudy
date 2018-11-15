package com.zerozzl.study.lang.thread;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread start");
		
		Thread task = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.println("child thread run " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		task.start();
		task.join();
		
		System.out.println("main thread end");
	}
	
}
