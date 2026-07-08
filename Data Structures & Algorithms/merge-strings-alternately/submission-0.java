class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        boolean alter = false;
        
        while (i < word1.length() && j < word2.length()){

            sb.append(!alter? word1.charAt(i++) : word2.charAt(j++));
            alter = !alter;
        }

        if (i < word1.length()){
            sb.append(word1.substring(i,word1.length()));
        }
         else{
            sb.append(word2.substring(j,word2.length()));
        }
        return sb.toString();
    }
}