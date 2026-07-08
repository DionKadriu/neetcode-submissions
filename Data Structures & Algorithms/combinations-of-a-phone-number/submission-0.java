class Solution {
    public List<String> letterCombinations(String digits) {
        
        if (digits.isEmpty()){
            return new ArrayList();
        }
        List<String> res = new ArrayList();
        backtrack(res,new StringBuilder(),0, digits);

        return res;
    }

    public void backtrack(List<String>res,StringBuilder path, int start, String digits ){

        if (path.length() == digits.length()){
            res.add(path.toString());
            return;
        }
        String word = getLetters(digits.charAt(start));
        
        for (char c : word.toCharArray()){
            path.append(c);
            backtrack(res,path,start+1, digits);
            path.deleteCharAt(path.length()-1);
        }

    }

    public String getLetters(char digit){

        switch (digit){

            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return ";";
        }
    }
}
