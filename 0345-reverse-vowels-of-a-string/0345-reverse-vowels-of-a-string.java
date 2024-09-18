class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = new HashSet<>();
        Collections.addAll(vowelSet, 'A', 'E', 'I', 'O', 'U',
                           'a', 'e', 'i', 'o', 'u');
        
        
        char[] charString = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowelSet.contains(charString[start])) {
                start ++;
            }
            while (start < end && !vowelSet.contains(charString[end])) {
                end --;
            }
            char temp = charString[start];
            charString[start] = charString[end];
            charString[end] = temp;
            
            start++;
            end--;
        }
        
        String result = new String(charString);
        return result;
        
        
//         int len = s.length();
//         List<Character> vowelList = new ArrayList<>();
        
//         for (int i = 0; i < len; i++) {
//             char curr = s.charAt(i);
//             if (vowelSet.contains(curr)) {
//                 vowelList.add(curr);
//             }
//         }
        
//         int vowelPointer = vowelList.size() - 1;
//         String result = "";
        
//         for (int i = 0; i < len; i++) {
//             char curr = s.charAt(i);
//             if (vowelSet.contains(curr)) {
//                 result += vowelList.get(vowelPointer);
//                 vowelPointer--;
//             } else {
//                 result += curr;
//             }
//         }
//         return result;
    }
}