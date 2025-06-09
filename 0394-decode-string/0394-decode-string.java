class Solution {
   public String decodeString(String s) {
       Stack<Pair<Integer, StringBuilder>> stack = new Stack<>();       
       StringBuilder curr = new StringBuilder();
       StringBuilder num = new StringBuilder();
      
       for (char currChar: s.toCharArray()) {           
           if (Character.isDigit(currChar)) {
               num.append(currChar);
           }           
           else if (currChar == '[') {
               stack.push(new Pair<>(Integer.valueOf(num.toString()), curr));
               num = new StringBuilder();
               curr = new StringBuilder();
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
