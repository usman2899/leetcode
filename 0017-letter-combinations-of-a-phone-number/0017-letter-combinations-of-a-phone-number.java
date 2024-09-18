class Solution {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        
        backtrack("", digits, result);
        return result;       
        
    }
    
    void backtrack(String combination, String digits, List<String> result) {
        if (digits.isEmpty()) {
            result.add(combination);
        } else {
            String letters = phoneMap.get(digits.charAt(0));
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination+letters.charAt(i), digits.substring(1), result);
            }
        }
    }
}

// ITERATIVE
//         List<String> result = new ArrayList<>();
//         Map<Character, String> phoneMap = new HashMap<Character, String>() {{
    //         put('2', "abc");
    //         put('3', "def");
    //         put('4', "ghi");
    //         put('5', "jkl");
    //         put('6', "mno");
    //         put('7', "pqrs");
    //         put('8', "tuv");
    //         put('9', "wxyz");
//         }};
        
//         if (digits.isEmpty()) {
//             return result;
//         }
        
//         int len = digits.length();
//         result.add("");
        
        
//         for (int i = 0; i < len; i++) {
//             String letters = phoneMap.get(digits.charAt(i));
//             List<String> current = new ArrayList<>();
            
//             for (String combination : result) {
//                 for (int k = 0; k < letters.length(); k++) {
//                     current.add(combination + letters.charAt(k));
//                 }
//             }            
//             result = current;
//         }
//         return result;
//     }
// }