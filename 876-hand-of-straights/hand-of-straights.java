class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize !=0) return false;
        
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for(int card : hand){
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        while(!freq.isEmpty()){
            int smallest = freq.firstKey();
            int count = freq.get(smallest);

            for(int i =0; i < groupSize; i++){

                int card = smallest + i;

                if(!freq.containsKey(card)) return false;
                if(freq.get(card) < count) return false;
                int remaining = freq.get(card) - count;
                if(remaining == 0) freq.remove(card);
                else freq.put(card, remaining);

            }
        }

        return true;

    }
}