import java.util.Stack;

public class Re {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))){
                int b = st.pop();
                if(st.isEmpty()) return b;
                int a = st.pop();
                if(token.equals("+")) st.push(a+b);
                if(token.equals("-")) st.push(a-b);
                if(token.equals("*")) st.push(a*b);
                if(token.equals("/")) st.push(a/b);
            }
            else st.push(Integer.parseInt(token));
        }
        return st.pop();
        
    }
} {
    
}
