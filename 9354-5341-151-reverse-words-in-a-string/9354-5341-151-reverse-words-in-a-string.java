class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while(i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i;
                while(j < len && s.charAt(j) != ' ') {
                    j++;
                }
                String word = s.substring(i,j);
                stack.push(word);
                i = j;
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
            result += " ";
        }
        return result.trim();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         String[] words = s.split(" ");
//         int left = 0;
//         int right = words.length - 1;

//         while (left < right) {
//             String temp = words[left];
//             words[left] = words[right];
//             words[right] = temp;
//             left++;
//             right--;
//         }

//         StringBuilder result = new StringBuilder();
//         for (String word : words) {
//             if (!word.isEmpty()) {
//                 if (result.length() > 0) {
//                     result.append(" ");
//                 }
//                 result.append(word);
//             }
//         }

//         return result.toString();
//     }
// }