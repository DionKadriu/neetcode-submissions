class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            
            if (token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if (token.equals("-")){
                int m = stack.pop();
                int n = stack.pop();
                stack.push(n - m);
            }
            else if (token.equals("/")){
int m = stack.pop();
                int n = stack.pop();
                stack.push(n/m);
            }
            else{
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public boolean isNotDigit(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
