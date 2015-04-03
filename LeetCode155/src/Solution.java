import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public final Stack<Integer> stack = new Stack<>();
	public final Stack<Integer> minStack = new Stack<>();
	public int currentMin = Integer.MAX_VALUE;

	public void push(int x) {
		stack.push(x);
		if (x <= currentMin) {
			minStack.push(x);
			currentMin = x;
		}
	}

	public void pop() {
		int element = stack.pop();
		if (element == currentMin) {
			minStack.pop();
			if (minStack.isEmpty())
				currentMin = Integer.MAX_VALUE;
			else
				currentMin = minStack.peek();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.push(2147483646);
		solution.push(2147483646);
		solution.push(2147483647);
		solution.top();
		solution.pop();
		solution.getMin();
		solution.pop();
		solution.getMin();
		solution.pop();
		solution.push(2147483647);
		solution.top();
		solution.getMin();
		solution.push(-2147483648);
		solution.top();
		solution.getMin();
		solution.pop();
		solution.getMin();

	}
}
