class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int curr = 0, result = 0;

        for (int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))) result++;
        }
        curr = result;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) curr++;
            if (isVowel(s.charAt(i - k))) curr--;
            result = Math.max(curr, result);
        }

        return result;        
    }

    boolean isVowel(Character c) {
        return (c.equals('a') || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u'));
    }
}