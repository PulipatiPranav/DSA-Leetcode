class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : tasks){
            freq.put(c , freq.getOrDefault(c, 0)  +1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq.values()){
            maxHeap.offer(f);
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int frequency = maxHeap.poll();
                frequency--;
                if(frequency > 0){
                    queue.offer(new int[] {frequency, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}