class Solution {
    public int evalRPN(String[] tokens) {
        // // Set<String> cSet = new HashSet<>();
        // // cSet.addAll(Arrays.asList( 
        // //     new String[] {"+", "-", "*", "/" }));
        // for (int i = 0; i < tokens.length; i++) {
        //     int num1, num2, result;
        //     num1 = num2 = result = 0;
        //     if (tokens[i].equals("+") || 
        //     tokens[i].equals("-") ||
        //     tokens[i].equals("*") ||
        //     tokens[i].equals("/")) {
        //         num1 = Integer.parseInt(tokens[i-1]);
        //         tokens[i-1] = "+";
        //         for (int j = 2; j < tokens.length; j++) {
        //             //if (!cSet.contains(tokens[i-j]))
        //             if (!((tokens[i-j].equals("+") || 
        //             tokens[i-j].equals("-") ||
        //             tokens[i-j].equals("*") ||
        //             tokens[i-j].equals("/")))) {
        //                 num2 = Integer.parseInt(tokens[i-j]);
        //                 tokens[i-j] = "+";
        //                 break;
        //             }
        //         }
        //         if (tokens[i].equals("+")) {
        //             result = num2 + num1;
        //         } 
        //         else if (tokens[i].equals("-")) {
        //             result = num2 - num1;
        //         } 
        //         else if (tokens[i].equals("*")) {
        //             result = num2 * num1;
        //         } 
        //         else {
        //             result = num2 / num1;
        //         }
        //         tokens[i] = String.valueOf(result);
        //     }
        // }
        // return Integer.parseInt(tokens[tokens.length-1]);

        Stack<Long> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                long integer2 = stack.pop();
                long integer1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(integer1, integer2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
    Long resolves(long a, long b, char Operator) {
        if (Operator == '+') return a + b;
        else if (Operator == '-') return a - b;
        else if (Operator == '*') return a * b;
        return a / b;
    }
}