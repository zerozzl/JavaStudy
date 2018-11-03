package com.zerozzl.study.java.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Composite {

	public abstract class Component {
		protected String name;
		protected List<Component> items;

		public Component(
				String name) {
			this.name = name;
			this.items = new ArrayList<Component>();
		}

		public abstract void operation();

		public void add(Component component) throws Exception {
			this.items.add(component);
		}

		public void romove(Component component) throws Exception {
			this.items.remove(component);
		}

		public List<Component> getChildren() throws Exception {
			return this.items;
		}
	}

	public class composite extends Component {

		public composite(
				String name) {
			super(name);
		}

		public void operation() {
			for (Component item : items) {
				item.operation();
			}
		}
	}

	public class Leaf extends Component {
		public Leaf(
				String name) {
			super(name);
			this.items = null;
		}

		public void operation() {
			System.out.println(this.name);
		}

		@Override
		public void add(Component component) throws Exception {
			throw new Exception();
		}

		@Override
		public void romove(Component component) throws Exception {
			throw new Exception();
		}

		@Override
		public List<Component> getChildren() throws Exception {
			throw new Exception();
		}
	}

	public static void main(String[] args) throws Exception {
		Composite self = new Composite();
		Component leaf1 = self.new Leaf("leaf1");
		Component composite1 = self.new composite("composite1");
		composite1.add(leaf1);
		composite1.operation();
	}

}
