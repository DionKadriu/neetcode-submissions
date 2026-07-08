class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> res= new ArrayList();

       backtrack(res,new ArrayList(),s, 0);

       return res; 
    }

    public void backtrack(List<List<String>> res, List<String> curr, String word, int start){

        if (start == word.length()){
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = start; i < word.length(); i++ ){

            if (isPalindrome(word.substring(start,i+1))){
                curr.add(word.substring(start,i+1));
                backtrack(res,curr,word,i+1);
                curr.remove(curr.size()-1);
            }

        }
    }

    public boolean isPalindrome(String word){
        if (word.length() ==1){
            return true;
        }
        int left =0;
        int right = word.length()-1;

        while (left< right){
            if (word.charAt(left)!= word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
