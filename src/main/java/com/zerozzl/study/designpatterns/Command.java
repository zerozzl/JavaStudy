package com.zerozzl.study.designpatterns;

/**
 * 命令
 */
public class Command {

	abstract class command {
		public abstract void execute();

		public abstract void undo();

		public abstract void redo();
	}

	class ConcreteCommand extends command {
		private Receiver receiver;
		private String state;
		private String lastState;

		public ConcreteCommand(
				Receiver receiver,
				String state) {
			this.receiver = receiver;
			this.state = state;
		}

		@Override
		public void execute() {
			this.lastState = receiver.getName();
			this.receiver.action(this.state);
		}

		@Override
		public void undo() {
			this.receiver.action(this.lastState);
			lastState = null;
		}

		@Override
		public void redo() {
			undo();
			execute();
		}
	}

	class Receiver {
		private String name;

		public void action(String name) {
			this.name = name;
			System.out.println("Name: " + this.name);
		}

		public String getName() {
			return name;
		}
	}

	class Invoker {
		private command cmd;

		public void setCommand(command cmd) {
			this.cmd = cmd;
		}

		public void invoke() {
			if (this.cmd != null) {
				cmd.execute();
			}
		}

		public void undoInvoke() {
			if (cmd != null) {
				cmd.undo();
			}
		}
	}

	public static void main(String[] args) {
		Command self = new Command();
		Receiver receiver = self.new Receiver();
		Invoker invoker = self.new Invoker();
		command cmd = self.new ConcreteCommand(receiver, "Hello World");
		invoker.setCommand(cmd);
		invoker.invoke();
		invoker.undoInvoke();
	}
	
}
