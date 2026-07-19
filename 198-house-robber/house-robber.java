class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] , (nums[i] + dp[i-2]));
        }
        return dp[nums.length-1];

        
    }
}

//two adjacent houses should not be robbed
//return max amount
//at every step , we can either choose the house or skip
//[1,2,3,1] -> 1+3 = 4 ; 2 + 1 = 3.
//[2,7,9,3,1] -> 2 + 9 + 1 = 12 ; 7 + 3 = 10; 
//dp[i] -> best profit so far. 
//if i skip , dp[i] = dp[i-1].
//if i considering , dp[i] = nums[i] + dp[i-2].
//hence, dp[i] = max(dp[i-1] , nums[i] + dp[i-2]).
//edge cases -> dp[0] = nums[0] , dp[1] = max(nums[0] , nums[1]).