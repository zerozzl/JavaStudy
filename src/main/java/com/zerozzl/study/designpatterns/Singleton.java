package com.zerozzl.study.designpatterns;

/**
 * 单例
 */
public class Singleton {

	private static class Holder {
		private static final Singleton instance = new Singleton();
	}

	private Singleton() {
	}

	public static Singleton getInstance() {
		return Holder.instance;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Singleton self = Singleton.getInstance();
	}

}
