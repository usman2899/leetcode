class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class Solution {
    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        populateTrie(wordDict);
        return searchWord(s);
    }

    void populateTrie(List<String> wordDict) {
        for (String word: wordDict) {
            char[] wordChar = word.toCharArray();
            TrieNode curr = root;
            for (char c: wordChar) {
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                } 
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
    }

    boolean searchWord(String s) {
        if (s.isEmpty()) return true; 
        
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (inDict(prefix)) {
                if (searchWord(s.substring(i))) {
                    return true; 
                }
            }
        }
        return false; 
    }

    boolean inDict(String word) {
        char[] wordChar = word.toCharArray();
        TrieNode curr = root;

        for (char c: wordChar) {
            if(!curr.children.containsKey(c)) {
                return false;
            } 
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
}