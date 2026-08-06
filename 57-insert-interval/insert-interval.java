class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a,b) -> Integer.compare(a[0] , b[0]));
        return mergeIntervals(list);
    }

    public int[][] mergeIntervals(List<int[]> intervals){
        List<int[]> ans = new ArrayList<>();
        for(int[] interval : intervals){
            if(ans.isEmpty()) ans.add(interval);
            else if(interval[0]  <= ans.get(ans.size() - 1)[1]){
                ans.get(ans.size() - 1)[1] = Math.max(interval[1] , ans.get(ans.size() - 1)[1]);
            }
            else{
                ans.add(interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}