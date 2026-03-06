//The approach to this problem involves counting the number of opening braces
//as left and the number of closing braces as right, In the first pass, when 
//left and right become equal , it means there exists a valid substring and 
//we update the  maxLength to the max value between current max and twice right
//or twice left, as they are equal. When right becomes more than left, it means
//that there exist more closing braces than opening ones, hence we resest the counters
//and start again. But only the left pass might miss the cases with incomplete opening
//braces at the begining ("(()") and only the right pass might miss the incomplete
//closing braces at the end ("())") hence, we rest the pointers after the left pass
//and perform the right pass to get the accurate Longest Valid Parenthesis Substring Length

class longestValidParentheses {

    public int Solution(String s) {

        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right) {
                max = Math.max(max, right * 2);
            }
            if (right > left) {
                right = 0;
                left = 0;
            }

        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                max = Math.max(max, 2 * left);
            if (left > right)
                left = right = 0;
        }

        return max;

    }
}