package com.zerozzl.study.designpatterns;

/**
 * 原型
 */
public class Prototype {

	class prototype implements Cloneable {
		public prototype clone() {
			prototype prototype = null;
			try {
				prototype = (prototype) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return prototype;
		}
	}

	public static void main(String[] args) {
		Prototype self = new Prototype();
		prototype parent = self.new prototype();
		@SuppressWarnings("unused")
		prototype child = parent.clone();
	}

}
