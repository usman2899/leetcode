class Solution {
    public String decodeString(String s) {
        Stack<Pair<Integer, StringBuilder>> stack = new Stack<>();
        
        StringBuilder curr = new StringBuilder();
        int num = 0; 
        
        for (char currChar: s.toCharArray()) {            
            if (Character.isDigit(currChar)) {
                num = num * 10 + (Character.getNumericValue(currChar));
            }
            
            else if (currChar == '[') {
                stack.push(new Pair<>(num, curr));
                num = 0;
                curr = new StringBuilder();;
            }
            
            else if (currChar == ']') {
                Pair<Integer, StringBuilder> pair = stack.pop();
                StringBuilder temp = pair.getValue();
                temp.append(curr.toString().repeat(pair.getKey()));
                curr = temp;
            }
            
            else {
                curr.append(currChar);
            }
        }
        
        return curr.toString();
    }
}