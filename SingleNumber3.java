public class SingleNumber3 {

    // The approach to this problem is xorring all elements and obtain the
    // xor result as the xor of the two distinct elements only, bcs everything
    // else gets cancelled. Then, we find the right most set bit, bcs if the xor
    // of two elements is not zero, they atleast differ by one bit, and we're trying
    // to get the least bit where that happens. Then we partition the array into
    // two parts and & each number to obtain either 0 (first distinct element) or 1
    // 1 (second distinct element) as they differ at that bit to obtain the result.

    public int[] Soluton(int[] nums) {
        int xor = 0; // initial xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // now xor would be x^y , where x and y are the only two distinct elements.
        int rmsb = xor & -xor;// the right most bit where the differ
        int num1 = 0;
        int num2 = 0;
        // the above two variables are for partitioning the array
        for (int num : nums) {
            if ((num & rmsb) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        int arr[] = new int[2]; // ans array
        arr[0] = num1;
        arr[1] = num2;
        return arr;

    }
}
