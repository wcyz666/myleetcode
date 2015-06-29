import java.util.LinkedList;
import java.util.Queue;
/*
 * class MyStack 
{
    Queue<Integer> queue;

    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}
 */

class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 0, length = queue.size() - 1; i < length; i++) {
            queue.offer(queue.poll());
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        Integer topElement = 0;
        for (int i = 0, length = queue.size(); i < length; i++) {
            topElement = queue.poll();
            queue.offer(topElement);
        }

        return topElement;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}