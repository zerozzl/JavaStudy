package com.zerozzl.study.lang.innerclass;

public class Sample1 {

	private double radius = 0;
	public static int count = 1;

	public Sample1(
			double radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println(new Draw().field);
	}

	class Draw { // 内部类
		
		private int field = 1;
		
		public void drawSahpe() {
			System.out.println(radius); // 外部类的private成员
			System.out.println(count); // 外部类的静态成员
		}
	}
	
	public static void main(String[] args) {
		Sample1 sample = new Sample1(5);
		Draw draw = sample.new Draw();
		sample.draw();
		draw.drawSahpe();
	}

}
