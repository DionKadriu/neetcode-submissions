class Solution {
    public boolean checkInclusion(String s1, String s2) {

        boolean[] used = new boolean[s1.length()];

        return backtrack(s1,new StringBuilder(),used,s2);
    }

  static boolean backtrack(String str, StringBuilder current, boolean[] used, String s2) {
        if (current.length() == str.length()) {

            if (s2.contains(current.toString())) {

                return true;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i]) {
                continue;
            }
            current.append(str.charAt(i));
            used[i] = true;

            if (backtrack(str, current, used, s2)) {
                 return true;
}

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
        return false;
    }
}
