import java.util.Stack;

class MyQueue {
    // Push element x to the back of queue.
    
    Stack<Integer> stackM = new Stack<>();
    Stack<Integer> stackS = new Stack<>();
    
    public void push(int x) {
        stackM.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stackS.isEmpty()) {
            while (!stackM.isEmpty())
                stackS.push(stackM.pop());
        }
        stackS.pop();
    }

    // Get the front element.
    public int peek() {
        if (stackS.isEmpty()) {
            while (!stackM.isEmpty())
                stackS.push(stackM.pop());
        }
        return stackS.peek();        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackM.isEmpty() && stackS.isEmpty();  
    }
}