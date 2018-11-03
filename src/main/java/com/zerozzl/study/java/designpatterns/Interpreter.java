package com.zerozzl.study.java.designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器
 */
public class Interpreter {

	class Context {
		private Map<String, Integer> valueMap = new HashMap<String, Integer>();

		public void addValue(String key,
				int value) {
			valueMap.put(key, value);
		}

		public int getValue(String key) {
			return valueMap.get(key);
		}
	}

	public abstract class AbstractExpression {
		public abstract int interpreter(Context context);
	}

	public class AddNonterminalExpression extends AbstractExpression {
		private AbstractExpression left;
		private AbstractExpression right;

		public AddNonterminalExpression(
				AbstractExpression left,
				AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(Context context) {
			return this.left.interpreter(context) + this.right.interpreter(context);
		}

	}

	public class DivisionNonterminalExpression extends AbstractExpression {
		private AbstractExpression left;
		private AbstractExpression right;

		public DivisionNonterminalExpression(
				AbstractExpression left,
				AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(Context context) {
			int value = this.right.interpreter(context);
			if (value != 0) {
				return this.left.interpreter(context) / value;
			}
			return -1;
		}

	}

	public class MultiplyNonterminalExpression extends AbstractExpression {
		private AbstractExpression left;
		private AbstractExpression right;

		public MultiplyNonterminalExpression(
				AbstractExpression left,
				AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(Context context) {
			return this.left.interpreter(context) * this.right.interpreter(context);
		}

	}

	public class SubtractNonterminalExpression extends AbstractExpression {
		private AbstractExpression left;
		private AbstractExpression right;

		public SubtractNonterminalExpression(
				AbstractExpression left,
				AbstractExpression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int interpreter(Context context) {
			return this.left.interpreter(context) - this.right.interpreter(context);
		}
	}

	public class TerminalExpression extends AbstractExpression {
		private int i;

		public TerminalExpression(
				int i) {
			this.i = i;
		}

		@Override
		public int interpreter(Context context) {
			return this.i;
		}

	}

	// (a*b)/(a-b+2)
	public static void main(String[] args) {
		Interpreter self = new Interpreter();
		Context context = self.new Context();
		context.addValue("a", 7);
		context.addValue("b", 8);
		context.addValue("c", 2);

		MultiplyNonterminalExpression multiplyValue = self.new MultiplyNonterminalExpression(
				self.new TerminalExpression(context.getValue("a")), self.new TerminalExpression(context.getValue("b")));

		SubtractNonterminalExpression subtractValue = self.new SubtractNonterminalExpression(
				self.new TerminalExpression(context.getValue("a")), self.new TerminalExpression(context.getValue("b")));

		AddNonterminalExpression addValue = self.new AddNonterminalExpression(subtractValue,
				self.new TerminalExpression(context.getValue("c")));

		DivisionNonterminalExpression divisionValue = self.new DivisionNonterminalExpression(multiplyValue, addValue);

		System.out.println(divisionValue.interpreter(context));
	}

}
