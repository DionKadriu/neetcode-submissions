class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        backtrack(0,0,res,new StringBuilder(),n);
        return res;
    }

    public void backtrack(int open, int closed,List<String> res, StringBuilder builder,int n){

        if (open == closed && open == n){
            res.add(builder.toString());
            return;
        }

        if (open < n){
            builder.append("(");
            backtrack(open + 1,closed,res,builder,n);
            builder.deleteCharAt(builder.length()-1);
        }
        if (closed < open){
            builder.append(")");
            backtrack(open,closed + 1,res,builder,n);
            builder.deleteCharAt(builder.length()-1);
        }

    }
}


