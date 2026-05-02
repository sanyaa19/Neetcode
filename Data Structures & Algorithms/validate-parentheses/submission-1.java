class Solution {
    public boolean isValid(String s) {
        Deque<Character> str = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') str.push(c);

            else{
                if(str.isEmpty()) return false;
                else if( (str.peek()=='(' && c==')') || (str.peek()=='{' && c=='}') || (str.peek()=='[' && c==']') ) str.pop();
                else return false;
            }
        }
        return str.isEmpty();
    }
}
