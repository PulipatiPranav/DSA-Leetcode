class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(houserob1(nums, 0, n-2) , houserob1(nums,1,n-1));
        
    }

    public int houserob1(int [] nums, int left, int right){

        if(left == right) return nums[left];
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left+1] = Math.max(nums[left] , nums[left+1]);
        for(int i =left + 2; i <= right; i++){
            dp[i] = Math.max(dp[i-1] , (dp[i-2] + nums[i]));
        }
        return dp[right];
    }
}

