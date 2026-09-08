class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int num : nums) total+= num;
        int prefix = 0;
        int suffix = 0;
        for(int i =0; i < nums.length; i++){
            suffix = total - nums[i] - prefix;
            if(suffix == prefix) return i;
            prefix += nums[i];
        }
        return -1;
    }
}