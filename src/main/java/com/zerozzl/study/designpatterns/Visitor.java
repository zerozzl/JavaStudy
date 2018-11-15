package com.zerozzl.study.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者
 */
public class Visitor {

	interface visitor {
		void visit(ConcreteElementA nodeA);

		void visit(ConcreteElementB nodeB);
	}

	class ConcreteVisitorA implements visitor {
		public void visit(ConcreteElementA nodeA) {
			System.out.println("***visitorA***");
			nodeA.operationA();
		}

		public void visit(ConcreteElementB nodeB) {
			System.out.println("***visitorA***");
			nodeB.operationB();
		}
	}

	class ConcreteVisitorB implements visitor {
		public void visit(ConcreteElementA nodeA) {
			System.out.println("***visitorB***");
			nodeA.operationA();
		}

		public void visit(ConcreteElementB nodeB) {
			System.out.println("***visitorB***");
			nodeB.operationB();
		}
	}

	interface Element {
		void accept(visitor visitor);
	}

	class ConcreteElementA implements Element {
		public void accept(visitor visitor) {
			visitor.visit(this);
		}

		public void operationA() {
			System.out.println("elementA operationA");
		}
	}

	class ConcreteElementB implements Element {
		public void accept(visitor visitor) {
			visitor.visit(this);
		}

		public void operationB() {
			System.out.println("elementB operationB");
		}
	}

	class ObjectStructure {
		List<Element> elements = new ArrayList<Element>();

		public void add(Element node) {
			elements.add(node);
		}

		public void visit(visitor visitor) {
			for (Element ele : elements) {
				ele.accept(visitor);
			}
		}
	}

	public static void main(String[] args) {
		Visitor self = new Visitor();
		ObjectStructure os = self.new ObjectStructure();
		os.add(self.new ConcreteElementA());
		os.add(self.new ConcreteElementB());
		os.visit(self.new ConcreteVisitorA());
		os.visit(self.new ConcreteVisitorB());
	}

}
