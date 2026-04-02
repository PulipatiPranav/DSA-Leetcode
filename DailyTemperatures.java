//The problem is to find the number of days until a warmer temperature for each day in the input array. 
// We can solve this problem using a stack to keep track of the indices of the temperatures. We iterate 
// through the input array of temperatures, and for each temperature, we check if it is warmer than the 
// temperature at the index on top of the stack. If it is, we pop the index from the stack and calculate 
// the number of days until a warmer temperature by subtracting the popped index from the current index. 
// We repeat this process until we find a temperature that is not warmer or the stack is empty. Finally, 
// we push the current index onto the stack. The time complexity of this approach is O(n) because each index 
// is pushed and popped at most once, and the space complexity is O(n) in the worst case when all temperatures 
// are in decreasing order.

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int size = temperatures.length;
        if(size ==0) return new int[]{0};
        int[] res = new int[size];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i <size; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int prev = st.pop();
                res[prev] = i-prev;
            }
            st.push(i);
        }
        return res;
    }
}