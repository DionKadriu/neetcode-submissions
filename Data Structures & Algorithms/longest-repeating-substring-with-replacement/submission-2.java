class Solution {
    public int characterReplacement(String s, int k) {

       HashMap<Character,Integer> map = new HashMap();

        int l = 0;
        int res = 0;
        int window = 0;
       for (int r = 0; r < s.length(); r++){

        map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
        window = Math.max(window, map.get(s.charAt(r)));
        while (( r - l +1 - window) > k){

        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);       
        l++;
 
  }

        res = Math.max(res, r - l +1);


       }

       return res;
    }
}



/***


0 A
1 A
2 A
3 B
4 A
5 B
6 B

A A A B A B B 

for (int i = 0; i < s.length(); i++){

    if (not the same swap it)

}

A 3


maxf = 3



res = 3





***/