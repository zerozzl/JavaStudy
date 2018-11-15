package com.zerozzl.study.lang.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	// 阈值
	private static final int THRESHOLD = 2;
	// 起始值
	private int start;
	// 结束值
	private int end;

	public ForkJoinTest(
			int start,
			int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		boolean compute = (end - start) <= THRESHOLD;
		int res = 0;
		if (compute) {
			for (int i = start; i <= end; i++) {
				res += i;
			}
		} else {
			// 如果长度大于阈值，则分割为小任务
			int mid = (start + end) / 2;
			ForkJoinTest task1 = new ForkJoinTest(start, mid);
			ForkJoinTest task2 = new ForkJoinTest(mid + 1, end);

			// 计算小任务的值
			task1.fork();
			task2.fork();

			// 得到两个小任务的值
			int task1Res = task1.join();
			int task2Res = task2.join();
			res = task1Res + task2Res;
		}
		return res;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTest task = new ForkJoinTest(1, 5);
		ForkJoinTask<Integer> submit = pool.submit(task);
		System.out.println("Final result: " + submit.get());
	}

}
