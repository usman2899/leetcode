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
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
            result.append(" ");
        }
        return result.toString().trim();
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         String[] words = s.split(" ");
//         int left = 0;
//         int right = words.length - 1;

//         // while (left < right) {
//         //     String temp = words[left];
//         //     words[left] = words[right];
//         //     words[right] = temp;
//         //     left++;
//         //     right--;
//         // }

//         StringBuilder result = new StringBuilder();
//         // String result = "";
//         for (int i = words.length - 1 ; i>=0; i--) {
//             if (!words[i].isEmpty()) {
//                 result.append(words[i]);
//                 result.append(" ");
//                 // result += words[i];
//                 // result += " ";
//             }
//         }

//         return result.toString().trim();
//     }
// }