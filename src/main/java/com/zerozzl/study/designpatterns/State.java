package com.zerozzl.study.designpatterns;

/**
 * 状态
 */
public class State {

	class Context {
		private state state;

		public Context(
				state state) {
			this.state = state;
		}

		public state getState() {
			return this.state;
		}

		public void setState(state state) {
			this.state = state;
		}

		public void run() {
			state.action(this);
		}

	}

	abstract class state {
		public abstract void action(Context context);
	}

	class OpenSate extends state {
		public void action(Context context) {
			System.out.println("开");
			context.setState(new CloseState());
		}
	}

	class CloseState extends state {
		public void action(Context context) {
			System.out.println("关");
			context.setState(new OpenSate());
		}
	}

	public static void main(String[] args) {
		State self = new State();
		Context context = self.new Context(self.new CloseState());
		context.run();
		context.run();
		context.run();
		context.run();
		context.run();
		context.run();
		context.run();
		context.run();
	}

}
