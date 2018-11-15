package com.zerozzl.study.designpatterns;

/**
 * 中介者
 */
public class Mediator {

	interface mediator {
		void operation(Colleague col);

		void registerColleague1(ConcreteColleague1 colleague);

		void registerColleague2(ConcreteColleague2 colleague);
	}

	class ConcreteMediator implements mediator {
		private ConcreteColleague1 colleague1;
		private ConcreteColleague2 colleague2;

		@Override
		public void operation(Colleague col) {
			if (col instanceof ConcreteColleague1) {
				colleague2.reponse();
			} else if (col instanceof ConcreteColleague2) {
				colleague1.reponse();
			}
		}

		@Override
		public void registerColleague1(ConcreteColleague1 colleague) {
			this.colleague1 = colleague;
		}

		@Override
		public void registerColleague2(ConcreteColleague2 colleague) {
			this.colleague2 = colleague;
		}
	}

	abstract class Colleague {
		protected mediator mediator;

		public Colleague(
				mediator mediator) {
			this.mediator = mediator;
		}

		public abstract void request();

		public abstract void reponse();
	}

	class ConcreteColleague1 extends Colleague {
		public ConcreteColleague1(
				mediator mediator) {
			super(mediator);
			mediator.registerColleague1(this);
		}

		@Override
		public void request() {
			System.out.println("ConcreteColleague1 send request");
			this.mediator.operation(this);
		}

		@Override
		public void reponse() {
			System.out.println("ConcreteColleague1 reponse");
		}
	}

	class ConcreteColleague2 extends Colleague {
		public ConcreteColleague2(
				mediator mediator) {
			super(mediator);
			mediator.registerColleague2(this);
		}

		@Override
		public void request() {
			System.out.println("ConcreteColleague2 send request");
			this.mediator.operation(this);
		}

		@Override
		public void reponse() {
			System.out.println("ConcreteColleague2 reponse");
		}

	}

	public static void main(String[] args) {
		Mediator self = new Mediator();
		ConcreteMediator mediator = self.new ConcreteMediator();
		Colleague colleague1 = self.new ConcreteColleague1(mediator),
				colleague2 = self.new ConcreteColleague2(mediator);
		colleague1.request();
		colleague2.request();
	}

}
