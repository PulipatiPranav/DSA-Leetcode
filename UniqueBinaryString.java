//The approach to this problem involves intitialising an empty string and traversing
//through the given array, and appending the negation of the character at the indice of
//the indice of the string in the array , to generate a unique string which does not exist 
//in the given array. This approach is dervied from the cantor's diagonal argument which is 
//used to prove that numbers are uncountable.

class UniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {

        // int size = nums.length;
        String s = "";
        for (int i = 0; i < nums.length; i++) {
            String temp = nums[i];
            if (temp.charAt(i) == '1')
                s += '0';
            else if (temp.charAt(i) == '0')
                s += '1';
        }
        return s;

    }
}