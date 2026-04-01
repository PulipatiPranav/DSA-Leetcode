//The approach to this problem involves using a stack data structure to keep track of the minimum value at 
// each level of the stack. When we push a new value onto the stack, we compare it with the current minimum 
// value (which is stored at the top of the stack) and update the minimum value accordingly. 
// his way, we can retrieve the minimum value in constant time by simply looking at the top of the stack. 
// The time complexity for push, pop, top, and getMin operations is O(1), and the space complexity is O(n) 
// in the worst case when all values are pushed onto the stack.
import java.util.*;
class MinStack {

    Stack<int[]> st;
    public MinStack() {

        st = new Stack<>();
        
    }
    
    public void push(int val) {

        if(st.isEmpty()) st.push(new int[]{val,val});
        else{
            int currMin = st.peek()[1];
            st.push(new int[]{val, Math.min(val, currMin)});
        }
         
    }
    
    public void pop() {

        st.pop();
        
    }
    
    public int top() {

        return st.peek()[0];
        
    }
    
    public int getMin() {


        return st.peek()[1];

        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */