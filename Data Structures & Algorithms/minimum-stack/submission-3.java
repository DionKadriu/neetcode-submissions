class MinStack {
    
    PriorityQueue<Integer> queue;
    Stack<Integer> stack;
    public MinStack() {
        queue = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }
    
    public void pop() {
        if (stack.peek().equals(queue.peek())){
            stack.pop();
            queue.poll();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        boolean eq = false;

        while (!eq){
            if (stack.contains(queue.peek())){
                return queue.peek();
            }
            else{
                queue.poll();
            }

        }
        return queue.peek();
    }
}




/**

stack 1 2  
queue -1




**/
