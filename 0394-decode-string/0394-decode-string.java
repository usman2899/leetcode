class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        
        String result = "";        
        String numToStack = "";
        
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            
            if (Character.isDigit(currChar)) {
                numToStack += currChar;
            }
            
            else if (currChar == '[') {
                stack.push(result);
                stack.push(numToStack);
                result = "";   
                numToStack = ""; 
            }
            
            else if (currChar == ']') {
                int iterations = Integer.valueOf(stack.pop());
                String prevString = stack.pop();
                
                StringBuilder repeatedString = new StringBuilder();
                for (int j = 0; j < iterations; j++) {
                    repeatedString.append(result);
                }
                
                result = prevString + repeatedString.toString();
            }
            
            else {
                result += currChar;
            }
        }
        
        return result;
    }
}