
//The approach to this problem involves making a mask of ones , with the mask size
//being equal to the length of the binary number and xorring the mask with the number
//to obtain the complement. To make the mask of ones, we first initialise an int mask 
//equal to one, and left shift it until the mask value is less than or equal to n to obtain 
//a one followed by a certain number of zeros , and we subtract one to convert it to a mask of ones.

class ComplementOfInteger {
    public int bitwiseComplement(int n) {

        if (n == 0)
            return 1;

        int mask = 1;
        while (mask <= n) {
            mask <<= 1;
        }
        return (mask - 1) ^ n;
    }
}