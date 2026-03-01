public class PowerOf4 {

    // The approach to the problem is first counting the number of set bits,
    // as the powers of four which are a subset of powers of two only have one
    // set bit. If the number of set bits in the first place is not 1, return false.
    // If the number of set bits is 1, check if the indice where the bit is set is
    // a multiple of 2, as powers of 4 are even powers of 2, we check this by using
    // the Integer.numberOfTrailingZeros function to count the number of trailing
    // zeros and hence the indice where the bit is set.

    public boolean isPowerOfFour(int n) {

        int setBitsCount = countSetBits(n);
        if (setBitsCount == 1) {
            int ind = Integer.numberOfTrailingZeros(n);
            if (ind % 2 == 0)
                return true;
            else
                return false;
        } else
            return false;

    }

    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
