class MinStack {

    private List<Integer> stack;
    private List<Integer> minValue;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minValue = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if (minValue.size() == 0 ) {
            minValue.add(val);
        } else if (val <= minValue.get(minValue.size() - 1) ) {
            minValue.add(val);
        }
    }
    
    public void pop() {
        if (this.top() == this.minValue.get(minValue.size() - 1)) {
            this.minValue.remove(minValue.size() - 1);
        }
        this.stack.remove(this.stack.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.minValue.get(minValue.size() - 1);
    }
}
