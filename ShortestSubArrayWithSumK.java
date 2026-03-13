import java.util.*;
class ShortestSubArrayWithSumK{

    public int solution(int[] nums, int k){
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        for(int i =0; i <n; i++){
            int sum = 0;
            for(int j =1; j <n; j++){
                sum+=nums[j];
                if(sum >=k){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) return -1;
        return minLen;


    }
}