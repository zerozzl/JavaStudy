package com.zerozzl.study.lang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});

		Future future1 = executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		System.out.println(future1.get()); // returns null if the task has finished correctly.

		Future future = executorService.submit(new Callable() {
			public Object call() throws Exception {
				System.out.println("Asynchronous Callable");
				return "Callable Result";
			}
		});
		System.out.println("future.get() = " + future.get());

		executorService.shutdown();
	}

}
