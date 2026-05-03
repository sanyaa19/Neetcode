class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Deque<int[]> temp = new ArrayDeque<>();

        int[] res = new int[temperatures.length];

        for(int t=0; t<temperatures.length; t++){
            
            while(!temp.isEmpty() && temperatures[t]>(temp.peek())[0]){
                int idx = (temp.pop())[1];
                res[idx] = t - idx;
            }

            temp.push(new int[]{temperatures[t], t});
        } 
        return res;
    }
}
