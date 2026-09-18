class MinStack {

    Stack<Integer> min;
    Stack<Integer> s;

    public MinStack() {
        s = new Stack();
        min = new Stack();
    }
    
    public void push(int val) {
         if (min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
        s.push(val);
    }
    
    public void pop() {
        int sval = s.peek();
        int minval = min.peek();

        if (sval == minval){
            min.pop();
        }
        s.pop();
    }   
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

