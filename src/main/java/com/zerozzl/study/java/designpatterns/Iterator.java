package com.zerozzl.study.java.designpatterns;

/**
 * 迭代器
 */
public class Iterator {

	interface Aggregate {
		void add(Object obj);

		Object get(int index);

		int size();

		AbstractIterator iterator();
	}

	class ConcreteAggregate implements Aggregate {
		private Object[] list;
		private int size = 0;
		private int index = 0;

		public ConcreteAggregate() {
			index = 0;
			size = 0;
			list = new Object[10];
		}

		@Override
		public void add(Object obj) {
			list[index++] = obj;
			size++;
		}

		@Override
		public Object get(int index) {
			return list[index];
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public AbstractIterator iterator() {
			return new ConcreteIterator(this);
		}
	}

	interface AbstractIterator {
		Object first();

		Object previous();

		Object next();

		boolean hasNext();
	}

	class ConcreteIterator implements AbstractIterator {
		private Aggregate aggregate;
		private int index = -1;

		public ConcreteIterator(
				Aggregate aggregate) {
			this.aggregate = aggregate;
		}

		@Override
		public Object previous() {
			if ((this.index - 1) < 0) {
				return null;
			} else {
				return this.aggregate.get(--index);
			}

		}

		@Override
		public Object next() {
			if ((this.index + 1) >= this.aggregate.size()) {
				return null;
			} else {
				return this.aggregate.get(++index);
			}
		}

		@Override
		public boolean hasNext() {
			if (this.index < (this.aggregate.size() - 1)) {
				return true;
			}
			return false;
		}

		@Override
		public Object first() {
			if (this.aggregate.size() <= 0) {
				return null;
			} else {
				return this.aggregate.get(0);
			}
		}

	}

	public static void main(String[] args) {
		Iterator self = new Iterator();
		Aggregate aggregate = self.new ConcreteAggregate();
		aggregate.add("a");
		aggregate.add("b");
		aggregate.add("c");
		aggregate.add("d");
		AbstractIterator it = aggregate.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
