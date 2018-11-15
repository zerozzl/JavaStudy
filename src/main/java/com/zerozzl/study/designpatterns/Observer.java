package com.zerozzl.study.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者
 */
public class Observer {

	interface Subject {
		void attach(observer observer);

		void detach(observer observer);

		void notifyObservers();
	}

	class ConcreteSubject implements Subject {
		private List<observer> observers = new ArrayList<observer>();

		public void attach(observer observer) {
			observers.add(observer);
		}

		public void detach(observer observer) {
			observers.remove(observer);
		}

		public void notifyObservers() {
			System.out.println("Subject change");
			if (observers != null && !observers.isEmpty()) {
				for (observer ob : observers) {
					ob.update();
				}
			}
		}

	}

	interface observer {
		void update();
	}

	class ConcreteObserver implements observer {

		private String name;

		public ConcreteObserver(
				String n) {
			this.name = n;
		}

		public void update() {
			System.out.println(name + " update");
		}
	}

	public static void main(String[] args) {
		Observer self = new Observer();
		ConcreteSubject subject = self.new ConcreteSubject();
		ConcreteObserver ob1 = self.new ConcreteObserver("Observer 1"), ob2 = self.new ConcreteObserver("Observer 2");
		subject.attach(ob1);
		subject.attach(ob2);
		subject.notifyObservers();
	}

}
