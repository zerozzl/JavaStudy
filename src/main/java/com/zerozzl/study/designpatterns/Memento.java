package com.zerozzl.study.designpatterns;

import java.util.Stack;

/**
 * 备忘录
 */
public class Memento {

	class memento {
		private String state;

		public memento(
				String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}

	class Originator {
		private String state;

		public Originator(
				String state) {
			this.state = state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public memento createMemento() {
			return new memento(this.state);
		}
	}

	class Caretaker {
		private Stack<memento> mementos = new Stack<memento>();

		public void addMemento(memento m) {
			mementos.push(m);
		}

		public memento getMemento() {
			if (!mementos.empty()) {
				return mementos.pop();
			}
			return null;
		}
	}

	public static void main(String[] args) {
		Memento self = new Memento();
		Caretaker caretaker = self.new Caretaker();
		Originator originator = self.new Originator("1");
		caretaker.addMemento(originator.createMemento());
		originator.setState("2");
		String restore = caretaker.getMemento().getState();
		System.out.println("Current originator state=" + originator.getState() + ", restore state=" + restore);
	}

}
