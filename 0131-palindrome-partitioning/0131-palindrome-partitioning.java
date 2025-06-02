class Solution {
    List<List<String>> allPartitions;
    
    public List<List<String>> partition(String s) {
        allPartitions = new ArrayList<>();
        findPartitions(s, new ArrayList<>());
        return allPartitions;
    }

    void findPartitions(String s, List<String> curr) {
        if (s.length() == 0) {
            allPartitions.add(new ArrayList<>(curr));
            return;
        }
        
        // Try all possible first substrings
        for (int i = 1; i <= s.length(); i++) {  
            String prefix = s.substring(0, i);
            if (isPalindrome(prefix)) {  
                curr.add(prefix);
                findPartitions(s.substring(i), curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;  
        
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}