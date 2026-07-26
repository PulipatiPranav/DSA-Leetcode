class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int prod1 = nums[size - 1] * nums[size -2] * nums[size - 3];
        int prod2 = nums[0] * nums[1] * nums[size -1];
        return Math.max(prod1, prod2);
    }
}
