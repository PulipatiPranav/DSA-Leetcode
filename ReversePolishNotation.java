import java.util.Stack;
// The approach to this problem involves using a stack data structure to evaluate the expression in Reverse
//  Polish Notation (RPN). We iterate through each token in the input array. If the token is an operator (+, -, *, /),
//  we pop the top two elements from the stack, perform the corresponding operation, and push the result back onto the stack.
// If the token is a number, we simply push it onto the stack. After processing all tokens, the final result will be the only 
// element left in the stack. The time complexity of this approach is O(n), where n is the number of tokens, and the space complexity 
// is O(n) in the worst case when all tokens are numbers.

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if ((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))) {
                int b = st.pop();
                if (st.isEmpty())
                    return b;
                int a = st.pop();
                if (token.equals("+"))
                    st.push(a + b);
                if (token.equals("-"))
                    st.push(a - b);
                if (token.equals("*"))
                    st.push(a * b);
                if (token.equals("/"))
                    st.push(a / b);
            } else
                st.push(Integer.parseInt(token));
        }
        return st.pop();

    }
}
