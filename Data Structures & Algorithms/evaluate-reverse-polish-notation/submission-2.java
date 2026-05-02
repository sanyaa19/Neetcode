class Solution {
    public int postfix(Deque<String> stack){
        String token = stack.pop();
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            
            int b = postfix(stack);
            int a = postfix(stack);

            switch (token){
                case "+":
                return a + b;
                
                case "-":
                return a - b;
                
                case "*":
                return a * b;
                
                case "/":
                return a / b;
            }
        }

        return Integer.parseInt(token);

    }
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for(String s : tokens){
            stack.push(s);
        }
        return postfix(stack);
    }
}
