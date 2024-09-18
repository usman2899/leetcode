class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        List<Character> vowelList = new ArrayList<>();
        Set<Character> vowelSet = new HashSet<>();
        Collections.addAll(vowelSet, 'A', 'E', 'I', 'O', 'U',
                           'a', 'e', 'i', 'o', 'u');
        
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (vowelSet.contains(curr)) {
                vowelList.add(curr);
            }
        }
        
        int vowelPointer = vowelList.size() - 1;
        String result = "";
        
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (vowelSet.contains(curr)) {
                result += vowelList.get(vowelPointer);
                vowelPointer--;
            } else {
                result += curr;
            }
        }
        return result;
    }
}