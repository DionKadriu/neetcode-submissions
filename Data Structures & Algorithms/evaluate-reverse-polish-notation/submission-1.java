class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();
        int result = 0;

        for(String token : tokens){
            switch (token){
                case "+" -> stack.push(stack.pop() + stack.pop());
    
                case "-" -> {
                    int f = stack.pop();
                    int b = stack.pop();
                    stack.push(b - f);
                }
                
                case "*" -> stack.push(stack.pop() * stack.pop());
                
                case "/" -> {
                    int f = stack.pop();
                    int b = stack.pop();
                    stack.push(b / f);
                }
                default ->  stack.push(Integer.parseInt(token));
            }
            
        }
        return stack.pop();
    }
}
