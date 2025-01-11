class TrieNode {
    Map <Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        char[] charArr = word.toCharArray();

        for (char currChar: charArr) {
            if (!currNode.children.containsKey(currChar)) {
                currNode.children.put(currChar, new TrieNode());   
            }
            currNode = currNode.children.get(currChar);
        }
        currNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        char[] charArr = word.toCharArray();

        for (char currChar: charArr) {
            if (!currNode.children.containsKey(currChar)) {
                return false;   
            }
            currNode = currNode.children.get(currChar);
        }
        return currNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        char[] charArr = prefix.toCharArray();

        for (char currChar: charArr) {
            if (!currNode.children.containsKey(currChar)) {
                return false;   
            }
            currNode = currNode.children.get(currChar);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */