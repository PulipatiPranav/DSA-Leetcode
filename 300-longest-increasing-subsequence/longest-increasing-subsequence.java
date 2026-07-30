class Solution {
    public int lengthOfLIS(int[] nums) {

        int size = nums.length;
        int[] dp = new int[size];
        int maxLen = 1;

        Arrays.fill(dp ,1);
        for(int i =1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] ) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            maxLen = Math.max(maxLen , dp[i]);
        }

        return maxLen;
        
    }
}