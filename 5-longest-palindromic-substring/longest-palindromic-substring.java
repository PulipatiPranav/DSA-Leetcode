class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        
        boolean[][] dp = new boolean[len][len];
        
        int maxLen = 1;
        int start = 0;
        for(int l =1; l <= len; l++){
            
            for(int i =0; i <=len - l; i++){
                int j = i + l -1;
                if(l == 1) dp[i][j] = true;
                else if(l == 2) dp[i][j] = (s.charAt(i) == s.charAt(j));
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]);
                }
                if((dp[i][j]) && (l > maxLen)){
                    maxLen = l;
                    start = i;
                }
                
            }
        }
        return s.substring(start, start + maxLen);

        
        
    }
}

//to check if a string is a palindrome, we need two pointers.
//hence the dp state has two variables.
//dp[i][j] states if the substr from i to j is a palindrome
//so, dp[i][j] = (s[i] == s[j]) && (dp[i+1][j-1]).
//the fuckass shit bout this is iteration is done by lengths and not indices.