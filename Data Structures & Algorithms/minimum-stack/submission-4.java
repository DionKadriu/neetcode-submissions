class MinStack {

    Stack<Integer> min;
    Stack<Integer> all;

    public MinStack() {
        min = new Stack();
        all = new Stack();
    }
    
    public void push(int val) {
        
        if (all.isEmpty()){
            min.push(val);
            all.push(val);
        }
        else{
            if (val <= min.peek()){
                min.push(val);
            }
            all.push(val);
        }
    }
    
    public void pop() {
        if (!min.isEmpty() && min.peek().equals(all.peek())){
                min.pop();
        }
        all.pop();
    }
    
    public int top() {
        return all.isEmpty()? 0 :all.peek();
    }
    
    public int getMin() {
        return min.isEmpty()? 0 : min.peek();
    }
}
