/**
 * https://leetcode.com/problems/implement-queue-using-stacks/submissions/1526222009/
 */

class MyQueue {
    ArrayList<Integer> stack = null;

    public MyQueue() {
        stack = new ArrayList<Integer>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(0);
    }

    public int peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */