//The approach to this problem involves using a binary search algorithm to find the duplicate number in the array. We initialize two pointers, low and high, to the minimum and maximum values in the array, respectively
//We then calculate the mid value and count how many numbers in the array are less than or equal to mid. If the count is greater than mid, it means that the duplicate number must be in the range of low to mid, so we update high to mid. Otherwise, the duplicate number must be in the range of mid+1 to high, so we update low to mid+1.
//  We repeat this process until low is equal to high, at which point low (or high) will be the duplicate number. This approach has a time complexity of O(n log n) due to the binary search and counting steps, and a space complexity of O(1) since we are using only a constant amount of extra space.

class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }

        return low;

    }
}