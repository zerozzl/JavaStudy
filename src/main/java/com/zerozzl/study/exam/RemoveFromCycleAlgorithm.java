package com.zerozzl.study.exam;

import java.util.LinkedList;
import java.util.List;

/* 出圈算法是一类比较典型的算法面试题，它可以很好地考察求职者的编程功底。由于它是一种循环的逻辑，因此它比起一般的基础算法题会更难一些。本例在回答该问题的同时，详细地讲解出圈算法的实现思路。
对于出圈的问题，它有一个比较大的困难点，就是它总是重复循环的，它的头就是它的尾巴，所以，出圈问题的循环语句是比较难写的。
该题目的圈的元素个数是50个，每次数到3或3的倍数的时候，就把当前元素出圈，并且继续数数，直到再遇到3的倍数。这里，如果下标从0开始，一直到一圈完成以后，它就会接到圈的首部，这应该如何处理呢？其实，最好的办法就是使用取余的办法，就可以始终得到3个倍数，无论它的倍数是多少，也不管它的元素个数是多少。
由于每次去掉元素以后，元素的个数会少一个，因此下一个3的倍数其实只需要走两步，在为其下标赋值的时候，需要减一，保持每次去掉的元素都是3的倍数。
说明：如果使用从0开始的下标开始计算，那么初始化的时候应该使用-1，这样就可以模拟元素已经减少一个了。
至于元素的保存，可以使用数组，也可以使用链表。数组的元素去掉以后，它的下一个元素是不会自动往前移动的，不太好使用，但是也可以使用。这里，最好是使用java.util.List链表来表示，它既有下标，又可以很方便地获得元素的当前个数，尽管效率比数组要稍微低一些，不过已经足够了。*/
public class RemoveFromCycleAlgorithm {

	public static int cycle(int total,
			int k) { // 功能方法
		List<Integer> dataList = new LinkedList<Integer>();// 创建链表对象
		for (int i = 0; i < total; i++) {
			// 添加数据元素
			dataList.add(new Integer(i + 1));
		}
		int index = 0; // 定义下标
		while (dataList.size() > 1) { // 一直循环去除数据，直到只剩下一个元素
			index = (index + k - 1) % dataList.size();// 得到应该出局的下标
			dataList.remove(index); // 去除元素
		}
		return dataList.get(0);// 返回它的值
	}

	// 主方法
	public static void main(String[] args) {
		System.out.println("该数字原来的位置是：" + cycle(50, 3));
	}

}
