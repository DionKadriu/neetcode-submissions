class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();

        backtracking(res,new ArrayList(), 0, s);
        return res;
    }

    public void backtracking(List<List<String>> res, List<String> path, int start, String s){

       if (start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++){

            if ( isPalindrome(s.substring(start,i + 1))){

                path.add(s.substring(start,i+1));

                backtracking(res,path,i+1,s);
                path.remove(path.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s){

        int l = 0;
        int r = s.length()-1;
        if(s.length() ==1){
            return true;
        }

        while (l <= r){

            if (s.charAt(r) != s.charAt(l)){
                return false;
            }
            r--;
            l++;
        }
        return true;

    }
}
