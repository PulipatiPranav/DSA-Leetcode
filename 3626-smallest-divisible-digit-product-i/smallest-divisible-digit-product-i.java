class Solution {
    public int smallestNumber(int n, int t) {
        for(int i =0; i < t; i++){
            int num = n + i;
            int temp = num;
            int prod = 1;
            while(num > 0){
                prod *= num%10;
                num = num/10;
            }
            if(prod % t == 0) return temp;
        }
        return -1;
    }
}