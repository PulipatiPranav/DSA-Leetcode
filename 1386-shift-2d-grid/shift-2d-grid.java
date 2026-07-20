class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> flat = new ArrayList<Integer>();
        for(int[] row : grid){
            for(int x : row){
                flat.add(x);
            }
        }

        int size = flat.size();
        k %= size;

        Collections.rotate(flat,k);
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i < m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(flat.get(index++));
            }
            ans.add(row);
        }
        
        return ans;
    }
}