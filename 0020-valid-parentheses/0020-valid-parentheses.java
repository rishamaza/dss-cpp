class Solution {
    public boolean isValid(String s) {
        /*
        // Ye stack oracle recommended h
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{')
                    || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        */
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
