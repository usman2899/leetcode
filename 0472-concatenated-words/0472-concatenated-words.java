class Solution {
    Set<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (recursion(word, 0, 0)) res.add(word);
        }
        return res;
    }

    boolean recursion (String s, int start, int count) {
        int len = s.length();
        if (start == len && count > 1) {
            return true;
        }
        for(int i = start; i < len; i++) {
            if (set.contains(s.substring(start, i+1))) {
                if (recursion(s, i+1, count+1)) return true;
            } 
        }
        return false;
    }
}