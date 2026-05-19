class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minValue;

    public MinStack() {
        this.stack = new Stack<>();
        this.minValue = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (minValue.isEmpty() || val <= minValue.peek()) {
            minValue.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int value = stack.pop();
        if (value == minValue.peek()) {
            minValue.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minValue.peek();
    }
}
