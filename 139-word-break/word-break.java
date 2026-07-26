class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        boolean dp[] = new boolean[size + 1];
        dp[0] = true;
        for(int i = 1; i<= size; i++){
            for(int j = 0; j < i; j++){
                if(dp[j]&& wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[size];
    }

}

//dp[i] reps if the prefix until index i can be segmented.
//so if the last word starts at index j , if dp[j] == true, and substr(j,i) exists in the dict, then dp[i] = true.
//base cases -> dp[0] = true, bcs empty string can be segmented.
//return dp[n] which would denote if the whole string can be segmented into words in the dictionary.